package com.xiaofu.auth.domain.service.impl;

import com.xiaofu.auth.domain.entity.AuthRolePermissionBO;
import com.xiaofu.auth.domain.service.AuthRolePermissionDomainService;
import com.xiaofu.auth.infra.basic.entity.AuthRolePermission;
import com.xiaofu.auth.infra.basic.service.AuthRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/18 1:02
 * @des
 */
@Service
public class AuthRolePermissionDomainServiceImpl implements AuthRolePermissionDomainService {
    @Autowired
    private AuthRolePermissionService authRolePermissionService;

    @Override
    public Boolean add(AuthRolePermissionBO authRolePermissionBO) {
        List<AuthRolePermission> rolePermissionList = new LinkedList<>();
        Long roleId = authRolePermissionBO.getRoleId();
        authRolePermissionBO.getPermissionIdList().forEach(permissionId -> {
            AuthRolePermission authRolePermission = new AuthRolePermission();
            authRolePermission.setRoleId(roleId);
            authRolePermission.setPermissionId(permissionId);
            rolePermissionList.add(authRolePermission);
        });
        boolean res = authRolePermissionService.saveBatch(rolePermissionList);
        return res;
    }

}
