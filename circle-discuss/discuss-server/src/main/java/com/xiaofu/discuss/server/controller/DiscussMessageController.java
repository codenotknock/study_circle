package com.xiaofu.discuss.server.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.base.Preconditions;
import com.xiaofu.common.entitiy.Result;
import com.xiaofu.discuss.server.convert.DiscussPostDTOConverter;
import com.xiaofu.discuss.server.dao.entity.DiscussPost;
import com.xiaofu.discuss.server.dto.DiscussMessageDTO;
import com.xiaofu.discuss.server.dto.DiscussPostDTO;
import com.xiaofu.discuss.server.dto.MessageDTO;
import com.xiaofu.discuss.server.enums.DiscussPostTypeEnum;
import com.xiaofu.discuss.server.service.DiscussMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 消息表 前端控制器
 * </p>
 *
 * @author xiaofu
 * @since 2024-03-18
 */
@RestController
@RequestMapping("/discuss/discuss-message/")
@Api(value = "私信管理", tags = {"私信"})
@Slf4j
public class DiscussMessageController {

    @Autowired
    private DiscussMessageService discussMessageService;

    @ApiOperation(value = "私信列表")
    @RequestMapping("getList")
    public Result<MessageDTO> getMessageList(int page,int size) {
        try {

            MessageDTO messageDTO = discussMessageService.getMessageList(page, size);
            return Result.ok(messageDTO);
        } catch (Exception e) {
            log.error("DiscussMessageController.getMessageList.error:{}", e.getMessage(), e);
            return Result.fail("发布帖子失败");
        }
    }

    @ApiOperation(value = "私信详情")
    @RequestMapping("getDetail")
    public Result<List<DiscussMessageDTO>> getMessageDetail(String conversationId) {
        try {
            List<DiscussMessageDTO> discussMessageDTOList= discussMessageService.getMessageDetail(conversationId);
            return Result.ok(discussMessageDTOList);
        } catch (Exception e) {
            log.error("DiscussMessageController.getMessageDetail.error:{}", e.getMessage(), e);
            return Result.fail("查看私信失败");
        }
    }

    @ApiOperation(value = "发送私信")
    @RequestMapping("send")
    public Result<Boolean> getMessageDetail(DiscussMessageDTO discussMessageDTO) {
        try {
            discussMessageService.sendMessage(discussMessageDTO);
            return Result.ok();
        } catch (Exception e) {
            log.error("DiscussMessageController.getMessageDetail.error:{}", e.getMessage(), e);
            return Result.fail("查看私信失败");
        }
    }


}
