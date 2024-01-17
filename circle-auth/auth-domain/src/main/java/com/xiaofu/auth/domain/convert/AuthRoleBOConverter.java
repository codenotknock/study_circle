package com.xiaofu.auth.domain.convert;

import com.xiaofu.auth.domain.entity.AuthRoleBO;
import com.xiaofu.auth.domain.entity.AuthUserBO;
import com.xiaofu.auth.domain.entity.AuthUserRoleBO;
import com.xiaofu.auth.infra.basic.entity.AuthRole;
import com.xiaofu.auth.infra.basic.entity.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xiaofu
 * @date 2024/1/17 20:50
 * @des
 */

@Mapper
public interface AuthRoleBOConverter {
    AuthRoleBOConverter INSTANCE = Mappers.getMapper(AuthRoleBOConverter.class);


    AuthRole convertBoToEntity(AuthRoleBO authRoleBO);
}
