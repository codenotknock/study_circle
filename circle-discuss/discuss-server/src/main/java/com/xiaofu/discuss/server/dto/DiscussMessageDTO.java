package com.xiaofu.discuss.server.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

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
@ApiModel("私信实体")
public class DiscussMessageDTO {
    @ApiModelProperty("私信id")
    private Long id;

    @ApiModelProperty("发消息的 id")
    private Long fromId;

    @ApiModelProperty("接收消息的 id")
    private Long toId;

    @ApiModelProperty("会话 id，由通信双方 id _拼接")
    private String conversationId;

    @ApiModelProperty("消息内容")
    private String content;

    @ApiModelProperty("消息状态：0未读 1已读 2删除")
    private Integer status;

    @ApiModelProperty("创建人")
    private String createdBy;

    @ApiModelProperty("创建时间")
    private Timestamp createdTime;

    @ApiModelProperty("修改人")
    private String updateBy;

    @ApiModelProperty("修改时间")
    private Timestamp updateTime;


    @ApiModelProperty("消息数量")
    private Integer count;

    @ApiModelProperty("未读消息数量")
    private Integer unread;

    @ApiModelProperty("用户id")
    private Long targetId;

    @ApiModelProperty("发送用户名")
    private String FromUsername;

    @ApiModelProperty("头像url")
    private String avatar;

    @ApiModelProperty("对方用户名")
    private String ToUsername;

}
