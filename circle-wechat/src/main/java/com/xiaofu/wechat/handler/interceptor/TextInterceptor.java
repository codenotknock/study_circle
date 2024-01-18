package com.xiaofu.wechat.handler.interceptor;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import org.springframework.stereotype.Component;

import java.util.Map;
/**
 * @author xiaofu
 * @date 2024/1/18 21:40
 * @des
 */
/**
 * 对微信公众号消息进行预处理、过滤等操作，根据具体业务需求决定是否允许继续执行后面的路由处理方法
 * <p>
 * 如果要中止消息的继续处理，即表示拦截了这个消息，需要返回 false。否则，在执行完当前拦截器操作后，允许消息的继续处理，返回 true
 */
@Component
public class TextInterceptor implements WxMpMessageInterceptor {

    @Override
    public boolean intercept(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) {
        String msg = wxMpXmlMessage.getContent();
        String msgType = wxMpXmlMessage.getMsgType();
        if (msgType.equals("text") && msg.contains("混蛋")) {
            wxMpXmlMessage.setContent("***");
            return true;
        }
        return true;
    }
}
