package com.xiaofu.auth.application.convert;

import com.xiaofu.auth.application.dto.AuthPermissionDTO;
import com.xiaofu.auth.domain.entity.AuthPermissionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xiaofu
 * @date 2024/1/18 0:22
 * @des
 */
@Mapper
public interface AuthPermissionDTOConverter {
    AuthPermissionDTOConverter INSTANCE = Mappers.getMapper(AuthPermissionDTOConverter.class);

    AuthPermissionBO convertDtoToBo(AuthPermissionDTO authPermissionDTO);

}
