package com.xiaofu.auth.domain.convert;

import com.xiaofu.auth.domain.entity.AuthPermissionBO;
import com.xiaofu.auth.infra.basic.entity.AuthPermission;
import com.xiaofu.auth.infra.basic.entity.AuthRolePermission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xiaofu
 * @date 2024/1/18 0:22
 * @des
 */
@Mapper
public interface AuthPermissionBOConverter {
    AuthPermissionBOConverter INSTANCE = Mappers.getMapper(AuthPermissionBOConverter.class);

    AuthPermission convertBoToEntity(AuthPermissionBO authPermissionBO);

}
