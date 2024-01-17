package com.xiaofu.auth.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2024-01-17
 */
@Data
@Accessors(chain = true)
@TableName("auth_user")
public class AuthUser extends BaseEntity {

    @TableField("user_name")
    private String userName;

    @TableField("nick_name")
    private String nickName;

    @TableField("email")
    private String email;

    @TableField("phone")
    private String phone;

    @TableField("password")
    private String password;

    @TableField("sex")
    private Integer sex;

    @TableField("avatar")
    private String avatar;

    @TableField("status")
    private Integer status;

    @TableField("introduce")
    private String introduce;

    @TableField("ext_json")
    private String extJson;

}
