package com.xiaofu.auth.domain.service;

import com.xiaofu.auth.domain.entity.AuthRoleBO;
import com.xiaofu.auth.domain.entity.AuthUserBO;

/**
 * @author xiaofu
 * @date 2024/1/17 20:55
 * @des
 */

public interface AuthRoleDomainService {

    boolean update(AuthRoleBO authRoleBO);

    boolean delete(AuthRoleBO authRoleBO);

    boolean add(AuthRoleBO authRoleBO);
}
