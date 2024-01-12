package com.xiaofu.subject.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 题目分类表
 * </p>
 *
 * @author xiaofu
 * @since 2024-01-11
 * @des 题目分类表
 */
@Data
@Accessors(chain = true)
@TableName("subject_category")
public class SubjectCategory extends BaseEntity {

    @TableField("category_name")
    private String categoryName;

    @TableField("category_type")
    private Integer categoryType;

    @TableField("image_url")
    private String imageUrl;

    @TableField("parent_id")
    private Long parentId;

}
