package com.xiaofu.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaofu.common.entitiy.page.PageResult;
import com.xiaofu.subject.common.constants.SubjectConstant;
import com.xiaofu.subject.common.util.IdWorkerUtil;
import com.xiaofu.subject.common.util.LoginUtil;
import com.xiaofu.subject.domain.covert.SubjectInfoBOConverter;
import com.xiaofu.subject.domain.entity.SubjectInfoBO;
import com.xiaofu.subject.domain.entity.SubjectOptionBO;
import com.xiaofu.subject.domain.handler.SubjectTypeHandler;
import com.xiaofu.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.xiaofu.subject.domain.redis.RedisUtil;
import com.xiaofu.subject.domain.service.SubjectInfoDomainService;
import com.xiaofu.subject.domain.service.SubjectLikedDomainService;
import com.xiaofu.subject.infra.basic.entity.SubjectInfo;
import com.xiaofu.subject.infra.basic.entity.SubjectInfoEs;
import com.xiaofu.subject.infra.basic.entity.SubjectLabel;
import com.xiaofu.subject.infra.basic.entity.SubjectMapping;
import com.xiaofu.subject.infra.basic.service.SubjectEsService;
import com.xiaofu.subject.infra.basic.service.SubjectInfoService;
import com.xiaofu.subject.infra.basic.service.SubjectLabelService;
import com.xiaofu.subject.infra.basic.service.SubjectMappingService;
import com.xiaofu.subject.infra.rpc.UserInfo;
import com.xiaofu.subject.infra.rpc.UserRpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xiaofu
 * @date 2024/1/13 18:10
 * @des 题目信息：工厂+策略模式  工厂包含了4中类型：单选、多选、判断、简答
 */
@Slf4j
@Service
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

    @Autowired
    private SubjectInfoService subjectInfoService;

    @Autowired
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;

    @Autowired
    private SubjectMappingService subjectMappingService;

    @Autowired
    private SubjectLabelService subjectLabelService;

    @Autowired
    private SubjectEsService subjectEsService;

    @Autowired
    private UserRpc userRpc;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private SubjectLikedDomainService subjectLikedDomainService;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectInfoDomainServiceImpl.add.bo:{}", JSON.toJSON(subjectInfoBO));
        }
        SubjectInfo subjectInfo = SubjectInfoBOConverter.INSTANCE.covertBoToEntity(subjectInfoBO);
        subjectInfoService.saveOrUpdate(subjectInfo);
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfoBO.getSubjectType());
        handler.add(subjectInfoBO);

        // 题目分类和标签处理 多对多的关系
        List<Long> categoryIds = subjectInfoBO.getCategoryIds();
        List<Long> labelIds = subjectInfoBO.getLabelIds();
        List<SubjectMapping> subjectMappingList = new LinkedList<>();
        categoryIds.forEach(categoryId -> {
            for (Long labelId : labelIds) {
                SubjectMapping subjectMapping = new SubjectMapping()
                        .setSubjectId(subjectInfoBO.getId()).setCategoryId(categoryId).setLabelId(labelId);
                subjectMappingList.add(subjectMapping);
            }
        });
        subjectMappingService.saveBatch(subjectMappingList);

        // redis放入zadd计入排行榜
        redisUtil.addScore(SubjectConstant.RANK_KEY, LoginUtil.getLoginId(), 1);

        // 同步到es
        SubjectInfoEs subjectInfoEs = new SubjectInfoEs();
        subjectInfoEs.setDocId(new IdWorkerUtil(1, 1, 1).nextId());
        subjectInfoEs.setSubjectId(subjectInfo.getId());
        subjectInfoEs.setSubjectAnswer(subjectInfoBO.getSubjectAnswer());
        subjectInfoEs.setCreateTime(System.currentTimeMillis());
        subjectInfoEs.setCreateUser(LoginUtil.getLoginId());
        subjectInfoEs.setSubjectName(subjectInfo.getSubjectName());
        subjectInfoEs.setSubjectType(subjectInfo.getSubjectType());
        subjectEsService.insert(subjectInfoEs);
    }

    @Override
    public PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO) {
        // 根据分类id和标签id查询出对应的题目
        List<SubjectMapping> subjectMappingList = subjectMappingService.queryByCategoryIdAndLabelId(subjectInfoBO.getCategoryId(), subjectInfoBO.getLabelId());
        List<Long> subjectIds = subjectMappingList.stream().map(SubjectMapping::getSubjectId).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(subjectIds)) {
            return null;
        }
        Page<SubjectInfo> page = subjectInfoBO.toMpPage();
        IPage<SubjectInfo> subjectInfoIPage = subjectInfoService.queryPageByIds(page, subjectIds);
        List<SubjectInfo> records = subjectInfoIPage.getRecords();
        if (null != subjectInfoBO.getSubjectDifficult()) {
            records = records.stream().filter(item -> Objects.equals(item.getSubjectDifficult(), subjectInfoBO.getSubjectDifficult())).collect(Collectors.toList());
            if(CollectionUtils.isEmpty(records)) {
                return  null;
            }
        }
        // 获取每个题目的多个标签名字
        subjectIds = records.stream().map(SubjectInfo::getId).collect(Collectors.toList());
        subjectMappingList = subjectMappingService.queryBySubjectIds(subjectIds);
        List<Long> labelIds = subjectMappingList.stream().map(SubjectMapping::getLabelId).distinct().collect(Collectors.toList());
        Map<Long, List<Long>> subjectIdToLabelIds = subjectMappingList.stream()
                .collect(Collectors.groupingBy(SubjectMapping::getSubjectId,  Collectors.mapping(SubjectMapping::getLabelId, Collectors.toList())));
        Map<Long, String> labelIdToName = subjectLabelService.listByIds(labelIds).stream().collect(Collectors.toMap(SubjectLabel::getId, SubjectLabel::getLabelName));

        List<SubjectInfoBO> subjectInfoBOList = SubjectInfoBOConverter.INSTANCE.covertEntityToBoList(records);
        subjectInfoBOList.forEach(item -> {
            List<Long> ids = subjectIdToLabelIds.get(subjectInfoBO.getId());
            List<String> labelNames = new LinkedList<>();
            for (Long labelId : ids) {
                labelNames.add(labelIdToName.get(labelId));
            }
            item.setLabelName(labelNames);
        });
        PageResult<SubjectInfoBO> subjectInfoBOPageResult = new PageResult<>();
        subjectInfoBOPageResult.setPageSize(subjectInfoBO.getPageSize());
        subjectInfoBOPageResult.setPageNo(subjectInfoBO.getPageNo());
        subjectInfoBOPageResult.setRecords(subjectInfoBOList);

        return subjectInfoBOPageResult;
    }

    @Override
    public SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO) {
        SubjectInfo subjectInfo = subjectInfoService.getById(subjectInfoBO.getId());
        if (null == subjectInfo) {
            return null;
        }
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        SubjectOptionBO optionBO = handler.query(subjectInfo.getId().intValue());
        SubjectInfoBO infoBO = SubjectInfoBOConverter.INSTANCE.covertEntityToBo(optionBO, subjectInfo);
        List<SubjectMapping> subjectMappingList = subjectMappingService.queryBySubjectIds(Collections.singletonList(subjectInfo.getId()));
        List<Long> labelIds = subjectMappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> labelList = subjectLabelService.listByIds(labelIds);
        List<String> labelName = labelList.stream().map(SubjectLabel::getLabelName).collect(Collectors.toList());
        infoBO.setLabelName(labelName);
        infoBO.setLiked(subjectLikedDomainService.isLiked(subjectInfoBO.getId().toString(), LoginUtil.getLoginId()));
        infoBO.setLikedCount(subjectLikedDomainService.getLikedCount(subjectInfoBO.getId().toString()));

        return infoBO;
    }

    @Override
    public PageResult<SubjectInfoEs> getSubjectPageBySearch(SubjectInfoBO subjectInfoBO) {
        SubjectInfoEs subjectInfoEs = new SubjectInfoEs();
        subjectInfoEs.setPageNo(subjectInfoBO.getPageNo());
        subjectInfoEs.setPageSize(subjectInfoBO.getPageSize());
        subjectInfoEs.setKeyWord(subjectInfoBO.getKeyWord());
        return subjectEsService.querySubjectList(subjectInfoEs);
    }


    @Override
    public List<SubjectInfoBO> getContributeList() {
        Set<ZSetOperations.TypedTuple<String>> typedTuples = redisUtil.rankWithScore(SubjectConstant.RANK_KEY, 0, 5);
        if (log.isInfoEnabled()) {
            log.info("getContributeList.typedTuples:{}", JSON.toJSONString(typedTuples));
        }
        if (CollectionUtils.isEmpty(typedTuples)) {
            return Collections.emptyList();
        }
        List<SubjectInfoBO> boList = new LinkedList<>();
        typedTuples.forEach((rank -> {
            SubjectInfoBO subjectInfoBO = new SubjectInfoBO();
            subjectInfoBO.setSubjectCount(rank.getScore().intValue());
            UserInfo userInfo = userRpc.getUserInfo(rank.getValue());
            subjectInfoBO.setCreateUser(userInfo.getNickName());
            subjectInfoBO.setCreateUserAvatar(userInfo.getAvatar());
            boList.add(subjectInfoBO);
        }));
        return boList;
    }

}
