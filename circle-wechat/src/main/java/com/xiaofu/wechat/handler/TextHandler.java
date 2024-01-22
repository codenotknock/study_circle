package com.xiaofu.wechat.handler;

import com.binarywang.spring.starter.wxjava.mp.properties.WxMpProperties;
import com.xiaofu.wechat.redis.RedisUtil;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaofu
 * @date 2024/1/18 21:47
 * @des
 */
@Component
public class TextHandler implements WxMpMessageHandler {
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private WxMpProperties wxMpProperties;


    private static final String KEY_WORD = "学习圈子";

    private static final String LOGIN_PREFIX = "loginCode";

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {

        // 接收消息内容
        String inContent = wxMessage.getContent();

        // 响应的消息内容
        String outContent;
        // 根据不同的关键字回复消息
        if (inContent.contains(KEY_WORD)) {
            Random random = new Random();
            outContent = String.valueOf(random.nextInt(10000));
            String numKey = redisUtil.buildKey(LOGIN_PREFIX, outContent);
            redisUtil.setNx(numKey, wxMpProperties.getAppId(), 5L, TimeUnit.MINUTES);

        }
//        else if (inContent.contains("java")) {
//            outContent = "hello java";
//        }
//        else if (inContent.contains("***")) {
//            outContent = "请文明用语";
//        } else
        else {
            outContent = "获取验证码请发送‘学习圈子’，其它功能还在开发中....";
        }

        // 构造响应消息对象
        return WxMpXmlOutMessage.TEXT().content(outContent).fromUser(wxMessage.getToUser())
                .toUser(wxMessage.getFromUser()).build();
    }
}
