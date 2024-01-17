package com.xiaofu.auth.domain.service.impl;

import com.xiaofu.auth.domain.convert.AuthRoleBOConverter;
import com.xiaofu.auth.domain.convert.AuthUserBOConverter;
import com.xiaofu.auth.domain.entity.AuthRoleBO;
import com.xiaofu.auth.domain.entity.AuthUserBO;
import com.xiaofu.auth.domain.service.AuthRoleDomainService;
import com.xiaofu.auth.infra.basic.entity.AuthRole;
import com.xiaofu.auth.infra.basic.entity.AuthUser;
import com.xiaofu.auth.infra.basic.service.AuthRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaofu
 * @date 2024/1/17 20:56
 * @des
 */
@Service
public class AuthRoleDomainServiceIml implements AuthRoleDomainService {

    @Autowired
    private AuthRoleService authRoleService;


    @Override
    public boolean update(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convertBoToEntity(authRoleBO);

        return authRoleService.updateById(authRole);
    }

    @Override
    public boolean delete(AuthRoleBO authRoleBO) {
        return authRoleService.removeById(authRoleBO.getId());
    }

    @Override
    public boolean add(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convertBoToEntity(authRoleBO);

        return authRoleService.save(authRole);
    }
}
