package com.xiaofu.auth.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xiaofu.auth.infra.basic.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

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
public class AuthRolePermissionBO{


    private Long id;

    private Long roleId;

    private Long permissionId;

    private List<Long> permissionIdList;
}
