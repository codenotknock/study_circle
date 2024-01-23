package com.xiaofu.subject.application.interceptor;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author xiaofu
 * @date 2024/1/23 23:58
 * @des  远程请求拦截
 */
@Component
public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        if (Objects.nonNull(request)) {
            String loginId = request.getHeader("loginId");
            if (StringUtils.isNotBlank(loginId)) {
                requestTemplate.header("loginId", loginId);
            }
        }
    }

}