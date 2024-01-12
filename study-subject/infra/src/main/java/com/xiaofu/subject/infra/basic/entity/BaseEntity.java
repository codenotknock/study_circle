package com.xiaofu.subject.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author xiaofu
 * @date 2024/1/12 21:52
 * @des
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id = 0L;

    private String createdBy;

    @TableField(fill = FieldFill.INSERT)
    private Timestamp createdTime;

    private String updateBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;

    @TableLogic
    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    private Integer isDeleted;
}
