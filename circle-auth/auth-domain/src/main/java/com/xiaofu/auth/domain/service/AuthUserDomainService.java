package com.xiaofu.auth.domain.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.xiaofu.auth.domain.entity.AuthUserBO;

/**
 * @author xiaofu
 * @date 2024/1/17 20:55
 * @des
 */

public interface AuthUserDomainService {
    Boolean register(AuthUserBO authUserBO);

    Boolean update(AuthUserBO authUserBO);

    Boolean delete(AuthUserBO authUserBO);

    SaTokenInfo doLogin(String validCode);

    AuthUserBO getUserInfo(AuthUserBO authUserBO);
}
