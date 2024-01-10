package com.xiaofu.subject.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value="SubjectCategory对象", description="题目分类表")
public class SubjectCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    @ApiModelProperty(value = "分类类型")
    private Integer categoryType;

    @ApiModelProperty(value = "图标连接")
    private String imageUrl;

    @ApiModelProperty(value = "父级id")
    private Long parentId;

    @ApiModelProperty(value = "创建人")
    private String createdBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "更新人")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "是否删除 0: 未删除 1: 已删除")
    private Boolean isDeleted;


}
