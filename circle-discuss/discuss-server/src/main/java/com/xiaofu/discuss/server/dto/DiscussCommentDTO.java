package com.xiaofu.discuss.server.dto;


import com.xiaofu.discuss.server.dao.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author xiaofu
 * @since 2024-03-18
 */
@Data
@Accessors(chain = true)
@ApiModel("帖子评论")
public class DiscussCommentDTO {
    @ApiModelProperty("评论id")
    private Long id;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("评论实体 id")
    private Long entityId;

    @ApiModelProperty("评论实体类型：1帖子评论 2评论回复")
    private int entityType;

    @ApiModelProperty("评论目标 id")
    private Long targetId;

    @ApiModelProperty("评论内容")
    private String content;

    @ApiModelProperty("评论状态：0有效 1无效")
    private Integer status;

    @ApiModelProperty("创建人")
    private String createdBy;

    @ApiModelProperty("创建时间")
    private Timestamp createdTime;

    @ApiModelProperty("修改人")
    private String updateBy;

    @ApiModelProperty("修改时间")
    private Timestamp updateTime;

}
