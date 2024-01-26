package com.xiaofu.auth.common.util;


import com.xiaofu.auth.common.context.LoginContextHolder;

/**
 * @author xiaofu
 * @date 2024/1/22 21:37
 * @des
 */
public class LoginUtil {

    public static String getLoginId() {
        return LoginContextHolder.getLoginId();
    }
}

