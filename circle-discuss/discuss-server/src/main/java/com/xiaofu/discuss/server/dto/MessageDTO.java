package com.xiaofu.discuss.server.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.util.List;

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
@ApiModel("私信列表")
public class MessageDTO {
    @ApiModelProperty("消息")
    private List<DiscussMessageDTO> discussMessageDTOList;

    @ApiModelProperty("未读消息总数量")
    private Integer unreadTotal;

    @ApiModelProperty("私信列表数量")
    private Integer conversationCount;
}
