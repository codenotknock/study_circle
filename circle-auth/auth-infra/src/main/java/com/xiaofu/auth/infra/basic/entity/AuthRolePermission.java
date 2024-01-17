package com.xiaofu.auth.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
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
@TableName("auth_role_Permission")
public class AuthRolePermission extends BaseEntity {


    @TableField("role_id")
    private Long roleId;

    @TableField("permission_id")
    private Long permissionId;


}
