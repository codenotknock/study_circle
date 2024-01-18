package com.xiaofu.wechat.config;

import com.binarywang.spring.starter.wxjava.mp.properties.WxMpProperties;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaofu
 * @date 2024/1/18 21:36
 * @des
 */
@Configuration
public class WxMpConfiguration {

    @Autowired
    private WxMpProperties wxMpProperties;


    /**
     * 微信客户端配置存储
     */
    @Bean
    public WxMpConfigStorage wxMpConfigStorage() {
        WxMpDefaultConfigImpl configStorage = new WxMpDefaultConfigImpl();
        // 设置微信公众号appId
        configStorage.setAppId(wxMpProperties.getAppId());
        // 设置微信公众号appSecret
        configStorage.setSecret(wxMpProperties.getSecret());
        // 设置微信公众号的token
        configStorage.setToken(wxMpProperties.getToken());
        // 设置微信公众号的EncodingAESKey
        configStorage.setAesKey(wxMpProperties.getAesKey());
        return configStorage;
    }

    /**
     * WxMpService多个实现类 声明一个实例
     */
    @Bean
    public WxMpService wxMpService() {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }
}
