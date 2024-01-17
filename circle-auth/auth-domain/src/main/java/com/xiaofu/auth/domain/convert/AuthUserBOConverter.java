package com.xiaofu.auth.domain.convert;

import com.xiaofu.auth.domain.entity.AuthUserBO;
import com.xiaofu.auth.infra.basic.entity.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xiaofu
 * @date 2024/1/17 20:50
 * @des
 */

@Mapper
public interface AuthUserBOConverter {
    AuthUserBOConverter INSTANCE = Mappers.getMapper(AuthUserBOConverter.class);


    AuthUser convertBoToEntity(AuthUserBO authUserDTO);

    AuthUserBO convertEntityToBo(AuthUser user);
}
