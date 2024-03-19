package com.xiaofu.discuss.server.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaofu.discuss.server.dao.entity.DiscussPost;

/**
 * <p>
 * 帖子表 服务类
 * </p>
 *
 * @author xiaofu
 * @since 2024-03-18
 */
public interface DiscussPostService extends IService<DiscussPost> {

    /**
     * 帖子发布
     */
    int addDiscussPost(DiscussPost discussPost);

    /**
     * 获取帖子
     */
    DiscussPost getDiscussPost(Long id);
}
