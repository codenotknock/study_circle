package com.xiaofu.auth.domain.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xiaofu.auth.domain.entity.AuthPermissionBO;

import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/18 0:28
 * @des
 */
public interface AuthPermissionDomainService {
    Boolean add(AuthPermissionBO permissionBO);

    Boolean update(AuthPermissionBO permissionBO);

    Boolean delete(AuthPermissionBO permissionBO);

    List<String> getPermission(String userName);
}
