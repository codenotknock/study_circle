package com.xiaofu.circle.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * @author xiaofu
 * @date 2024/1/19 21:12
 * @des  网关跨域
 */

public class CorsConfig {
    @Bean
    public CorsWebFilter corsWebFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        CorsConfiguration corsConfig = new CorsConfiguration();
        // 允许所有请求方法
        corsConfig.addAllowedMethod("*");
        // 允许所有域，当请求头
        corsConfig.addAllowedOrigin("*");
        // 允许全部请求头
        corsConfig.addAllowedHeader("*");
        // 允许携带 Cookie 等用户凭证
        corsConfig.setAllowCredentials(true);
        // 允许全部请求路径
        source.registerCorsConfiguration("/**", corsConfig);
        return new CorsWebFilter(source);
    }

}