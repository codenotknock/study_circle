package com.xiaofu.subject.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 简答题信息表_题目信息
 * </p>
 *
 * @author xiaofu
 * @since 2024-01-13
 */
@Data
@Accessors(chain = true)
@TableName("subject_brief")
public class SubjectBrief extends BaseEntity{

    /**
     * 题目id
     */
    @TableField("subject_id")
    private Long subjectId;

    /**
     * 题目答案
     */
    @TableField("subject_answer")
    private String subjectAnswer;

}
