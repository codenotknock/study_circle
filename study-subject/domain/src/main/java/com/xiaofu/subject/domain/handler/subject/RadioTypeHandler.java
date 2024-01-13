package com.xiaofu.subject.domain.handler.subject;

import com.xiaofu.subject.common.enums.SubjectInfoTypeEnum;
import com.xiaofu.subject.domain.entity.SubjectInfoBO;
import com.xiaofu.subject.domain.handler.SubjectTypeHandler;
import com.xiaofu.subject.infra.basic.entity.SubjectRadio;

/**
 * @author xiaofu
 * @date 2024/1/13 18:26
 * @des  单选题的策略类
 */
public class RadioTypeHandler implements SubjectTypeHandler {
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 单选题目的插入
        SubjectRadio subjectRadio = new SubjectRadio();


    }
}
