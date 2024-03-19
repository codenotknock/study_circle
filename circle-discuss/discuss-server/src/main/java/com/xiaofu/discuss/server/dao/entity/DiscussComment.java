package com.xiaofu.discuss.server.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

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
@TableName("discuss_comment")
public class DiscussComment extends BaseEntity {

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 评论实体 id
     */
    @TableField("entity_id")
    private Long entityId;

    /**
     * 评论实体类型：1帖子评论 2评论回复
     */
    @TableField("entity_type")
    private int entityType;

    /**
     * 评论目标 id
     */
    @TableField("target_id")
    private Long targetId;

    /**
     * 评论内容
     */
    @TableField("content")
    private String content;

    /**
     * 评论状态：0有效 1无效
     */
    @TableField("status")
    private Integer status;

}
