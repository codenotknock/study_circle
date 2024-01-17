package com.xiaofu.auth.application.dto;


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
public class AuthRoleDTO {


    private Long id;

    private String roleName;

    private String roleKey;



}
