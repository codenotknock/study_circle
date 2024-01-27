package com.xiaofu.subject.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * 点赞信息
 * </p>
 *
 * @author xiaofu
 * @since 2024-01-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("subject_liked")
public class SubjectLiked extends BaseEntity {

    /**
     * 题目id
     */
    @TableField("subject_id")
    private Long subjectId;

    /**
     * 点赞人id
     */
    @TableField("like_user_id")
    private String likeUserId;

    /**
     * 点赞状态 0未点赞 1点赞
     */
    @TableField("status")
    private Integer status;

}
