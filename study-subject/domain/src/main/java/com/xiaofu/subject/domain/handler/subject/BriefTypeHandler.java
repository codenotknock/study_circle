package com.xiaofu.subject.domain.handler.subject;

import com.xiaofu.subject.common.enums.SubjectInfoTypeEnum;
import com.xiaofu.subject.domain.entity.SubjectInfoBO;
import com.xiaofu.subject.domain.handler.SubjectTypeHandler;
import com.xiaofu.subject.infra.basic.entity.SubjectBrief;
import com.xiaofu.subject.infra.basic.service.SubjectBriefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xiaofu
 * @date 2024/1/13 18:26
 * @des  简答题的策略类
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler {
    @Autowired
    private SubjectBriefService subjectBriefService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 简答题的插入
        SubjectBrief subjectBrief = new SubjectBrief();
        subjectBrief.setId(subjectInfoBO.getId());
        subjectBrief.setSubjectAnswer(subjectInfoBO.getSubjectAnswer());
        subjectBriefService.save(subjectBrief);

    }
}
