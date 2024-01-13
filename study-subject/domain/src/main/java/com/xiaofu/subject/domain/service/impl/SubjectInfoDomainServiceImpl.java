package com.xiaofu.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.xiaofu.subject.domain.covert.SubjectInfoBOConverter;
import com.xiaofu.subject.domain.entity.SubjectInfoBO;
import com.xiaofu.subject.domain.handler.SubjectTypeHandler;
import com.xiaofu.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.xiaofu.subject.domain.service.SubjectInfoDomainService;
import com.xiaofu.subject.infra.basic.entity.SubjectInfo;
import com.xiaofu.subject.infra.basic.service.SubjectInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectInfoDomainServiceImpl.add.bo:{}", JSON.toJSON(subjectInfoBO));
        }
        SubjectInfo subjectInfo = SubjectInfoBOConverter.INSTANCE.covertBoToInfo(subjectInfoBO);
        subjectInfoService.saveOrUpdate(subjectInfo);
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfoBO.getSubjectType());
        handler.add(subjectInfoBO);
    }
}
