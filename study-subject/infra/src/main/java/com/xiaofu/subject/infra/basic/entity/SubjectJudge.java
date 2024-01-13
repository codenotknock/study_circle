package com.xiaofu.subject.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 判断题信息表_题目信息
 * </p>
 *
 * @author xiaofu
 * @since 2024-01-13
 */
@Data
@Accessors(chain = true)
@TableName("subject_judge")
public class SubjectJudge extends BaseEntity {

    /**
     * 题目id
     */
    @TableField("subject_id")
    private Long subjectId;

    /**
     * 是否正确
     */
    @TableField("is_correct")
    private Integer isCorrect;

}
