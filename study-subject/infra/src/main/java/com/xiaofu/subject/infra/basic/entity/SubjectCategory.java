package com.xiaofu.subject.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@TableName("subject_category")
public class SubjectCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String categoryName;

    private Integer categoryType;

    private String imageUrl;

    private Long parentId;

    private String createdBy;

    private LocalDateTime createdTime;

    private String updateBy;

    private LocalDateTime updateTime;

    private Boolean isDeleted;


}
