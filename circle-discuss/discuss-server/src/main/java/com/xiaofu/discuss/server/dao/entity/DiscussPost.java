package com.xiaofu.discuss.server.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 帖子表
 * </p>
 *
 * @author xiaofu
 * @since 2024-03-18
 */
@Data
@Accessors(chain = true)
@TableName("discuss_post")
public class DiscussPost  extends BaseEntity {

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 帖子表标题
     */
    @TableField("title")
    private String title;

    /**
     * 帖子内容
     */
    @TableField("content")
    private String content;

    /**
     * 帖子类型 0普通 1置顶
     */
    @TableField("type")
    private Integer type;

    /**
     * 评论数量
     */
    @TableField("comment_count")
    private Integer commentCount;

    /**
     * 帖子状态：0普通 1精华 2拉黑
     */
    @TableField("status")
    private Integer status;


}
