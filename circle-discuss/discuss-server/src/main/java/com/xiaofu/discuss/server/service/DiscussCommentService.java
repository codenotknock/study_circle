package com.xiaofu.discuss.server.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaofu.discuss.server.dao.entity.DiscussComment;

import java.util.List;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author xiaofu
 * @since 2024-03-18
 */
public interface DiscussCommentService extends IService<DiscussComment> {

    /**
     * 添加评论
     */

    int addDiscussComment(DiscussComment discussComment);

    /**
     * 获取评论
     */

    List<DiscussComment> getDiscussComment(Long entityId);


}
