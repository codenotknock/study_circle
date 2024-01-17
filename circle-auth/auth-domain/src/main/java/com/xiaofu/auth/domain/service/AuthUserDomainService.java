package com.xiaofu.auth.domain.service;

import com.xiaofu.auth.domain.entity.AuthUserBO;

/**
 * @author xiaofu
 * @date 2024/1/17 20:55
 * @des
 */

public interface AuthUserDomainService {
    boolean register(AuthUserBO authUserBO);

    boolean update(AuthUserBO authUserBO);

    boolean delete(AuthUserBO authUserBO);
}
