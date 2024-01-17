package com.xiaofu.auth.application.convert;

import com.xiaofu.auth.application.dto.AuthRoleDTO;
import com.xiaofu.auth.application.dto.AuthUserDTO;
import com.xiaofu.auth.application.dto.AuthUserRoleDTO;
import com.xiaofu.auth.domain.entity.AuthRoleBO;
import com.xiaofu.auth.domain.entity.AuthUserBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xiaofu
 * @date 2024/1/17 20:50
 * @des
 */

@Mapper
public interface AuthRoleDTOConverter {
    AuthRoleDTOConverter INSTANCE = Mappers.getMapper(AuthRoleDTOConverter.class);


    AuthRoleBO convertDTOToBO(AuthRoleDTO authRoleDTO);
}
