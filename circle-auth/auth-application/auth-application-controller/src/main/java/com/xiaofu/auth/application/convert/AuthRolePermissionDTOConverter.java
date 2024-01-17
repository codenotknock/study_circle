package com.xiaofu.auth.application.convert;

import com.xiaofu.auth.application.dto.AuthRoleDTO;
import com.xiaofu.auth.application.dto.AuthRolePermissionDTO;
import com.xiaofu.auth.domain.entity.AuthRoleBO;
import com.xiaofu.auth.domain.entity.AuthRolePermissionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xiaofu
 * @date 2024/1/18 1:00
 * @des
 */
@Mapper
public interface AuthRolePermissionDTOConverter {
    AuthRolePermissionDTOConverter INSTANCE = Mappers.getMapper(AuthRolePermissionDTOConverter.class);


    AuthRolePermissionBO convertDtoToBo(AuthRolePermissionDTO authRolePermissionDTO);
}
