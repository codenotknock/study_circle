package com.xiaofu.subject.domain.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 题目分类表
 * </p>
 *
 * @author xiaofu
 * @since 2024-01-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SubjectCategoryBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String categoryName;

    private Integer categoryType;

    private String imageUrl;

    private Long parentId;



}
