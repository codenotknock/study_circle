package com.xiaofu.subject.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 单选题信息表_题目信息
 * </p>
 *
 * @author xiaofu
 * @since 2024-01-12
 */
@Data
@Accessors(chain = true)
@TableName("subject_radio")
public class SubjectRadio extends BaseEntity {

    /**
     * 题目id
     */
    @TableField("subject_id")
    private Long subjectId;

    /**
     * 选项a b c d e
     */
    @TableField("option_type")
    private Integer optionType;

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
