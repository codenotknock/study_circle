package com.xiaofu.discuss.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaofu.discuss.server.dao.entity.DiscussPost;
import com.xiaofu.discuss.server.dao.mapper.DiscussPostMapper;
import com.xiaofu.discuss.server.service.DiscussPostService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 帖子表 服务实现类
 * </p>
 *
 * @author xiaofu
 * @since 2024-03-18
 */
@Service
public class DiscussPostServiceImpl extends ServiceImpl<DiscussPostMapper, DiscussPost> implements DiscussPostService {

    @Override
    public int addDiscussPost(DiscussPost discussPost) {
        return this.getBaseMapper().insert(discussPost);
    }

    @Override
    public DiscussPost getDiscussPost(Long id) {
        return lambdaQuery()
                .eq(DiscussPost::getId, id)
                .one();
    }
}
