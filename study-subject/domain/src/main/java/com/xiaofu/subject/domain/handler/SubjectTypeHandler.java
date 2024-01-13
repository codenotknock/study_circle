package com.xiaofu.subject.domain.handler;

import com.xiaofu.subject.common.enums.SubjectInfoTypeEnum;
import com.xiaofu.subject.domain.entity.SubjectInfoBO;
import com.xiaofu.subject.domain.entity.SubjectOptionBO;

/**
 * @author xiaofu
 * @date 2024/1/13 18:23
 * @des
 */
public interface SubjectTypeHandler {

    /**
     * 题目类型识别
     */

    SubjectInfoTypeEnum getHandlerType();


    /**
     * 实际题目的添加
     */

    void add(SubjectInfoBO subjectInfoBO);


    SubjectOptionBO query(int subjectId);
}
