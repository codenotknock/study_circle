package com.xiaofu.subject.application.interceptor;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.xiaofu.subject.common.context.LoginContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.lang.Nullable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiaofu
 * @date 2024/1/22 21:30
 * @des
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String loginId = request.getHeader("loginId");
        if (StringUtils.isNotBlank(loginId)) {
            LoginContextHolder.set("loginId", loginId);
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        LoginContextHolder.remove();
    }

}