package com.xiaofu.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaofu.subject.common.entity.page.PageResult;
import com.xiaofu.subject.domain.covert.SubjectInfoBOConverter;
import com.xiaofu.subject.domain.entity.SubjectInfoBO;
import com.xiaofu.subject.domain.handler.SubjectTypeHandler;
import com.xiaofu.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.xiaofu.subject.domain.service.SubjectInfoDomainService;
import com.xiaofu.subject.infra.basic.entity.SubjectInfo;
import com.xiaofu.subject.infra.basic.entity.SubjectLabel;
import com.xiaofu.subject.infra.basic.entity.SubjectMapping;
import com.xiaofu.subject.infra.basic.service.SubjectInfoService;
import com.xiaofu.subject.infra.basic.service.SubjectLabelService;
import com.xiaofu.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

    @Override
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
            item.setLabelNames(labelNames);
        });


        return new PageResult<>(subjectInfoBOList);
    }
}
