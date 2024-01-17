package com.xiaofu.auth.application.dto;

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
public class AuthRolePermissionDTO {


    private Long id;

    private Long roleId;

    private Long permissionId;

    private List<Long> permissionIdList;
}
