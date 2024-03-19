package com.xiaofu.discuss.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaofu.discuss.server.dao.entity.DiscussMessage;
import com.xiaofu.discuss.server.dto.DiscussMessageDTO;
import com.xiaofu.discuss.server.dto.MessageDTO;

import java.util.List;

/**
 * <p>
 * 消息表 服务类
 * </p>
 *
 * @author xiaofu
 * @since 2024-03-18
 */
public interface DiscussMessageService extends IService<DiscussMessage> {

    /**
     * 私信列表
     */

    MessageDTO getMessageList(int page, int size);

    /**
     * 私信详情
     */

    List<DiscussMessageDTO> getMessageDetail(String conversationId);

    /**
     * 发送私信
     */

    void sendMessage(DiscussMessageDTO discussMessageDTO);


    /**
     * 私信已读
     */

    void readMessage(DiscussMessageDTO discussMessageDTO);

}
