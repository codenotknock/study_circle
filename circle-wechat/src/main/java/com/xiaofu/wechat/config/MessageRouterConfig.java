package com.xiaofu.wechat.config;

import com.xiaofu.wechat.handler.SubscribeHandler;
import com.xiaofu.wechat.handler.TextHandler;
import com.xiaofu.wechat.handler.interceptor.TextInterceptor;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpMessageInterceptor;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaofu
 * @date 2024/1/18 21:40
 * @des
 */
@Configuration
public class MessageRouterConfig {
    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private TextHandler textHandler;
    @Autowired
    private TextInterceptor textInterceptor;
    @Autowired
    private SubscribeHandler subscribeHandler;
    @Bean
    public WxMpMessageRouter messageRouter() {
        // 创建消息路由
        final WxMpMessageRouter router = new WxMpMessageRouter(wxMpService);
        // 添加一个同步处理文本消息的路由规则 同时添加interceptor、handler
        router.rule().async(false).msgType(WxConsts.XmlMsgType.TEXT).interceptor((WxMpMessageInterceptor) textInterceptor).handler(textHandler).end();
        // 订阅事件
        router.rule().async(false).msgType(WxConsts.XmlMsgType.EVENT).event(WxConsts.EventType.SUBSCRIBE).handler(subscribeHandler).end();

        return router;
    }
}
