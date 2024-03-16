package com.xiaofu.practice.server.utils;

import com.xiaofu.practice.server.context.LoginContextHolder;

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

