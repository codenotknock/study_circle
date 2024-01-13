package com.xiaofu.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.xiaofu.subject.domain.covert.SubjectInfoBOConverter;
import com.xiaofu.subject.domain.entity.SubjectInfoBO;
import com.xiaofu.subject.domain.handler.SubjectTypeHandler;
import com.xiaofu.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.xiaofu.subject.domain.service.SubjectInfoDomainService;
import com.xiaofu.subject.infra.basic.entity.SubjectInfo;
import com.xiaofu.subject.infra.basic.entity.SubjectMapping;
import com.xiaofu.subject.infra.basic.service.SubjectInfoService;
import com.xiaofu.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

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
}
