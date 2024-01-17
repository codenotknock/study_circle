package com.xiaofu.auth.domain.service.impl;

import com.xiaofu.auth.common.enums.AuthUserStatusEnum;
import com.xiaofu.auth.domain.convert.AuthUserBOConverter;
import com.xiaofu.auth.domain.entity.AuthUserBO;
import com.xiaofu.auth.domain.service.AuthUserDomainService;
import com.xiaofu.auth.infra.basic.entity.AuthUser;
import com.xiaofu.auth.infra.basic.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaofu
 * @date 2024/1/17 20:56
 * @des
 */
@Service
public class AuthUserDomainServiceIml implements AuthUserDomainService {

    @Autowired
    private AuthUserService authUserService;

    @Override
    public boolean register(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBoToEntity(authUserBO);
        authUser.setStatus(AuthUserStatusEnum.OPEN.code);
        boolean res = authUserService.save(authUser);
        return res;
    }

    @Override
    public boolean update(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBoToEntity(authUserBO);

        return authUserService.updateById(authUser);
    }

    @Override
    public boolean delete(AuthUserBO authUserBO) {
        return authUserService.removeById(authUserBO.getId());
    }
}
