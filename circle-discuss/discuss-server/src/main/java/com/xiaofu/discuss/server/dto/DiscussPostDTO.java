package com.xiaofu.discuss.server.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * @author xiaofu
 * @date 2024/3/18 16:43
 * @des 帖子相关参数
 */
@Data
@Accessors(chain = true)
@ApiModel("帖子参数")
public class DiscussPostDTO {
    @ApiModelProperty("帖子id")
    private Long id;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("帖子表标题")
    private String title;

    @ApiModelProperty("帖子内容")
    private String content;

    @ApiModelProperty("帖子类型 0普通 1置顶")
    private Integer type;

    @ApiModelProperty("评论数量")
    private Integer commentCount;

    @ApiModelProperty("帖子状态：0普通 1精华 2拉黑")
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
