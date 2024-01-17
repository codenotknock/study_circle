package com.xiaofu.auth.application.convert;

import com.xiaofu.auth.application.dto.AuthUserDTO;
import com.xiaofu.auth.domain.entity.AuthUserBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xiaofu
 * @date 2024/1/17 20:50
 * @des
 */

@Mapper
public interface AuthUserDTOConverter {
    AuthUserDTOConverter INSTANCE = Mappers.getMapper(AuthUserDTOConverter.class);


    AuthUserBO convertDTOToBO(AuthUserDTO authUserDTO);
}
