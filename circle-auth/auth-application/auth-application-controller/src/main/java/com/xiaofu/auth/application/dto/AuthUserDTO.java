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
public class AuthUserDTO {


    private Long id;

    private String userName;

    private String nickName;

    private String email;

    private String phone;

    private String password;

    private Integer sex;

    private String avatar;

    private Integer status;

    private String introduce;

    private String extJson;

}
