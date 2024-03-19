package com.xiaofu.discuss.server.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 消息表
 * </p>
 *
 * @author xiaofu
 * @since 2024-03-18
 */
@Data
@Accessors(chain = true)
@TableName("discuss_message")
public class DiscussMessage extends BaseEntity {

    /**
     * 发消息的 id
     */
    @TableField("from_id")
    private Long fromId;

    /**
     * 接收消息的 id
     */
    @TableField("to_id")
    private Long toId;

    /**
     * 会话 id，由通信双方 id 拼接
     */
    @TableField("conversation_id")
    private String conversationId;

    /**
     * 消息内容
     */
    @TableField("content")
    private String content;

    /**
     * 消息状态：0未读 1已读 2删除
     */
    @TableField("status")
    private Integer status;


}
