package com.xiaofu.subject.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 多选题信息表_题目信息
 * </p>
 *
 * @author xiaofu
 * @since 2024-01-13
 */
@Data
@Accessors(chain = true)
@TableName("subject_multiple")
public class SubjectMultiple extends BaseEntity {

    /**
     * 题目id
     */
    @TableField("subject_id")
    private Long subjectId;

    /**
     * 选项类型
     */
    @TableField("option_type")
    private Long optionType;

    /**
     * 选项内容
     */
    @TableField("option_content")
    private String optionContent;

    /**
     * 是否正确
     */
    @TableField("is_correct")
    private Integer isCorrect;

}
