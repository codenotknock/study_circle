package com.xiaofu.subject.domain.handler.subject;

import com.xiaofu.subject.common.enums.SubjectInfoTypeEnum;
import com.xiaofu.subject.domain.entity.SubjectInfoBO;
import com.xiaofu.subject.domain.handler.SubjectTypeHandler;

/**
 * @author xiaofu
 * @date 2024/1/13 18:26
 * @des  简答题的策略类
 */
public class BriefTypeHandler implements SubjectTypeHandler {
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {

    }
}
