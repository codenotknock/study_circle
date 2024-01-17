package com.xiaofu.auth.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaofu
 * @since 2024-01-18
 */
@Data
@Accessors(chain = true)
@TableName("auth_permission")
public class AuthPermission extends BaseEntity {

    @TableField("name")
    private String name;

    @TableField("parent_id")
    private Long parentId;

    @TableField("type")
    private Integer type;

    @TableField("menu_url")
    private String menuUrl;

    @TableField("status")
    private Integer status;

    @TableField("show")
    private Integer show;

    @TableField("icon")
    private String icon;

    @TableField("permission_key")
    private String permissionKey;

}
