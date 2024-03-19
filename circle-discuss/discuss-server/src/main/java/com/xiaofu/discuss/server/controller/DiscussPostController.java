package com.xiaofu.discuss.server.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.base.Preconditions;
import com.xiaofu.common.entitiy.Result;
import com.xiaofu.discuss.server.context.UserContextHolder;
import com.xiaofu.discuss.server.convert.DiscussCommentDTOConverter;
import com.xiaofu.discuss.server.convert.DiscussPostDTOConverter;
import com.xiaofu.discuss.server.dao.entity.DiscussComment;
import com.xiaofu.discuss.server.dao.entity.DiscussPost;
import com.xiaofu.discuss.server.dto.DiscussCommentDTO;
import com.xiaofu.discuss.server.dto.DiscussPostDTO;
import com.xiaofu.discuss.server.enums.DiscussCommentStatusEnum;
import com.xiaofu.discuss.server.enums.DiscussCommentTypeEnum;
import com.xiaofu.discuss.server.enums.DiscussPostTypeEnum;
import com.xiaofu.discuss.server.service.DiscussCommentService;
import com.xiaofu.discuss.server.service.DiscussPostService;
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
 * 帖子表 前端控制器
 * </p>
 *
 * @author xiaofu
 * @since 2024-03-18
 */
@RestController
@RequestMapping("/discuss/discuss-post/")
@Api(value = "帖子讨论区", tags = {"帖子", "评论"})
@Slf4j
public class DiscussPostController {
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private DiscussCommentService discussCommentService;

    @ApiOperation(value = "发布帖子")
    @RequestMapping("publish")
    public Result<Boolean> addDiscussPost(@RequestBody DiscussPostDTO discussPostParam) {
        try {
            if (log.isInfoEnabled()) {
                log.info("DiscussPostController.addDiscussPost.dto:{}", JSON.toJSONString(discussPostParam));
            }
            Preconditions.checkArgument(!StringUtils.isBlank(discussPostParam.getContent()), "帖子内容不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(discussPostParam.getTitle()), "帖子标题不能为空");
            DiscussPost discussPost = DiscussPostDTOConverter.INSTANCE.convertDtoToEntity(discussPostParam);
            discussPost.setUserId(UserContextHolder.id());
            discussPost.setType(DiscussPostTypeEnum.NOMAL.getCode());
            discussPostService.addDiscussPost(discussPost);
            return Result.ok();
        } catch (Exception e) {
            log.error("UserController.addDiscussPost.error:{}", e.getMessage(), e);
            return Result.fail("发布帖子失败");
        }
    }

    @ApiOperation(value = "查看帖子")
    @RequestMapping("get")
    public Result<DiscussPostDTO> getDiscussPost(@RequestBody DiscussPostDTO discussPostParam) {
        try {
            if (log.isInfoEnabled()) {
                log.info("DiscussPostController.get.dto:{}", JSON.toJSONString(discussPostParam));
            }
            Preconditions.checkNotNull(discussPostParam.getId(), "帖子id不能为空");
            DiscussPost discussPost = discussPostService.getDiscussPost(discussPostParam.getId());
            DiscussPostDTO discussPostDTO = DiscussPostDTOConverter.INSTANCE.convertEntityToDto(discussPost);
            return Result.ok(discussPostDTO);
        }catch (Exception e) {
            log.error("UserController.add.error:{}", e.getMessage(), e);
            return Result.fail("查看帖子失败");
        }
    }
    @ApiOperation("添加评论")
    @RequestMapping("comment/add")
    public Result<DiscussCommentDTO> addComment(@RequestBody DiscussCommentDTO discussCommentParam) {
        try {
            if (log.isInfoEnabled()) {
                log.info("DiscussPostController.addComment.dto:{}", JSON.toJSONString(discussCommentParam));
            }
            Preconditions.checkArgument(!StringUtils.isBlank(discussCommentParam.getContent()), "评论内容不能为空");
            Preconditions.checkNotNull(discussCommentParam.getEntityId(), "评论实体不能为空");
            discussCommentParam.setStatus(DiscussCommentStatusEnum.VALID.code());
            discussCommentParam.setEntityType(DiscussCommentTypeEnum.COMMENTS.code());
            DiscussComment discussComment = DiscussCommentDTOConverter.INSTANCE.convertDtoToEntity(discussCommentParam);
            discussComment.setUserId(UserContextHolder.id());
            discussCommentService.addDiscussComment(discussComment);
            return Result.ok();
        } catch (Exception e) {
            log.error("UserController.addComment.error:{}", e.getMessage(), e);
            return Result.fail("添加评论失败");
        }
    }
    @ApiOperation("查看帖子评论")
    @RequestMapping("comment/get")
    public Result<List<DiscussCommentDTO>> getComment(@RequestBody DiscussCommentDTO discussCommentParam) {
        try {
            if (log.isInfoEnabled()) {
                log.info("DiscussPostController.getComment.dto:{}", JSON.toJSONString(discussCommentParam));
            }
            Preconditions.checkNotNull(discussCommentParam.getId(), "评论id不能为空");
            List<DiscussComment> discussCommentList = discussCommentService.getDiscussComment(discussCommentParam.getEntityId());
            List<DiscussCommentDTO> discussCommentDTOList = DiscussCommentDTOConverter.INSTANCE.convertEntityToDtoList(discussCommentList);
            return Result.ok(discussCommentDTOList);
        }catch (Exception e) {
            log.error("UserController.getComment.error:{}", e.getMessage(), e);
            return Result.fail("查看评论失败");
        }
    }







}
