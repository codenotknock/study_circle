package com.xiaofu.discuss.server.service.impl;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaofu.api.UserFeignService;
import com.xiaofu.common.entitiy.Result;
import com.xiaofu.discuss.server.context.UserContextHolder;
import com.xiaofu.discuss.server.convert.DiscussMessageDTOConverter;
import com.xiaofu.discuss.server.dao.entity.DiscussMessage;
import com.xiaofu.discuss.server.dao.mapper.DiscussMessageMapper;
import com.xiaofu.discuss.server.dto.DiscussMessageDTO;
import com.xiaofu.discuss.server.dto.MessageDTO;
import com.xiaofu.discuss.server.enums.DiscussMessageStatusEnum;
import com.xiaofu.discuss.server.service.DiscussMessageService;
import com.xiaofu.entity.AuthUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 消息表 服务实现类
 * </p>
 *
 * @author xiaofu
 * @since 2024-03-18
 */
@Service
public class DiscussMessageServiceImpl extends ServiceImpl<DiscussMessageMapper, DiscussMessage> implements DiscussMessageService {

    @Autowired
    private UserFeignService userFeignService;

    @Override
    public MessageDTO getMessageList(int page, int size) {
        int offset = (page - 1) * size;
        Long userId = UserContextHolder.id();
        List<DiscussMessage> discussMessageList = this.baseMapper.getConversations(userId, offset, size);
        List<DiscussMessageDTO> conversations = DiscussMessageDTOConverter.INSTANCE.convertEntityToDtoList(discussMessageList);
        for (DiscussMessageDTO discussMessageDTO : conversations) {
            Long tempUid  = null;
            if (userId.equals(discussMessageDTO.getFromId())) {
                tempUid = discussMessageDTO.getToId();
            } else {
                tempUid = discussMessageDTO.getFromId();
            }
            Result<AuthUserDTO> userInfo = userFeignService.getUserInfo(new AuthUserDTO().setId(tempUid));
            discussMessageDTO.setAvatar(userInfo.getData().getAvatar());
            discussMessageDTO.setFromUsername(userInfo.getData().getNickName());
            discussMessageDTO.setTargetId(tempUid);
            int letterCount = this.baseMapper.selectLetterCount(discussMessageDTO.getConversationId());
            int unreadNum = this.baseMapper.selectUnread(discussMessageDTO.getConversationId());
            discussMessageDTO.setCount(letterCount);
            discussMessageDTO.setUnread(unreadNum);
        }
        int unreadTotal = this.baseMapper.selectTotalUnread(userId);
        int conversationCount = this.baseMapper.getConversationCount(userId);

        MessageDTO messageDTO = new MessageDTO()
                                    .setDiscussMessageDTOList(conversations)
                                    .setUnreadTotal(unreadTotal)
                                    .setConversationCount(conversationCount);

        return messageDTO;
    }

    @Override
    public List<DiscussMessageDTO> getMessageDetail(String conversationId) {
        List<DiscussMessage> discussMessageList = this.baseMapper.selectLetters(conversationId);
        List<DiscussMessageDTO> discussMessageDTOList = DiscussMessageDTOConverter.INSTANCE.convertEntityToDtoList(discussMessageList);
        if (CollectionUtils.isNotEmpty(discussMessageDTOList)) {
            Long fromId = discussMessageDTOList.get(0).getFromId();
            Result<AuthUserDTO> userInfo = userFeignService.getUserInfo(new AuthUserDTO().setId(fromId));
            discussMessageDTOList.get(0).setFromUsername(userInfo.getData().getNickName());
            discussMessageDTOList.get(0).setAvatar(userInfo.getData().getAvatar());
            int letterNum = this.baseMapper.selectLetterCount(conversationId);
            discussMessageDTOList.get(0).setCount(letterNum);
        }

        return discussMessageDTOList;
    }

    @Override
    public void sendMessage(DiscussMessageDTO discussMessageDTO) {
        DiscussMessage discussMessage = DiscussMessageDTOConverter.INSTANCE.convertDtoToEntity(discussMessageDTO);;
        Result<AuthUserDTO> toUserInfo = userFeignService.getUserInfo(new AuthUserDTO().setUserName(discussMessageDTO.getToUsername()));
        Long fromId = UserContextHolder.id();
        Long toId = toUserInfo.getData().getId();
        if (fromId > toId) {
            discussMessage.setConversationId(toId + "_" + fromId);
        } else {
            discussMessage.setConversationId(fromId + "_" + toId);
        }
        discussMessage.setFromId(fromId);
        discussMessage.setToId(toId);
        discussMessage.setStatus(DiscussMessageStatusEnum.READ.code());

        this.baseMapper.insert(discussMessage);
    }

    @Override
    public void readMessage(DiscussMessageDTO discussMessageDTO) {
        UpdateWrapper<DiscussMessage> updateWrapper = new UpdateWrapper<DiscussMessage>()
                .eq("conversation_id", discussMessageDTO.getConversationId())
                .eq("to_id", UserContextHolder.id())
                .set("status", DiscussMessageStatusEnum.READ.code());
        this.baseMapper.update(null, updateWrapper);
    }


}
