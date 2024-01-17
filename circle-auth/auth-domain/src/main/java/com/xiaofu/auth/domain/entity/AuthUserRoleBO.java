package com.xiaofu.auth.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaofu
 * @since 2024-01-17
 */
@Data
@Accessors(chain = true)
public class AuthUserRoleBO {

    private Long id;

    private Long userId;

    private Long roleId;

}
