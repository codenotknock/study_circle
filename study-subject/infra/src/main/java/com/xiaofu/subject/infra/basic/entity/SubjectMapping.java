package com.xiaofu.subject.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 题目分类关系表
 * </p>
 *
 * @author xiaofu
 * @since 2024-01-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("subject_mapping")
public class SubjectMapping extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 题目id
     */
    @TableField("subject_id")
    private Long subjectId;

    /**
     * 分类id
     */
    @TableField("category_id")
    private Long categoryId;

    /**
     * 标签id
     */
    @TableField("label_id")
    private Long labelId;


}
