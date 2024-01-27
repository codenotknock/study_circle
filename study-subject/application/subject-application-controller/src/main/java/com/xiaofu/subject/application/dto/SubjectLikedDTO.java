package com.xiaofu.subject.application.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * @author xiaofu
 * @date 2024/1/28 3:05
 * @des
 */

@Data
@Accessors(chain = true)
public class SubjectLikedDTO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 题目id
     */
    private Long subjectId;

    /**
     * 点赞人id
     */
    private String likeUserId;

    /**
     * 点赞状态 1点赞 0不点赞
     */
    private Integer status;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Timestamp createdTime;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private Timestamp updateTime;

    /**
     *
     */
    private Integer isDeleted;
}
