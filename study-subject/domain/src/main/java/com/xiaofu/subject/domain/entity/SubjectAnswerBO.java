package com.xiaofu.subject.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author xiaofu
 * @date 2024/1/13 2:50
 * @des 题目答案
 */
@Data
@Accessors(chain = true)
public class SubjectAnswerBO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 答案选项标识
     */
    private Long optionType;

    /**
     * 答案
     */
    private String optionContent;

    /**
     * 是否正确
     */
    private Integer isCorrect;

}
