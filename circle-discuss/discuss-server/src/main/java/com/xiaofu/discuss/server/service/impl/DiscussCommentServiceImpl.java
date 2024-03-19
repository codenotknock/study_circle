package com.xiaofu.discuss.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaofu.discuss.server.dao.entity.DiscussComment;
import com.xiaofu.discuss.server.dao.mapper.DiscussCommentMapper;
import com.xiaofu.discuss.server.enums.DiscussCommentStatusEnum;
import com.xiaofu.discuss.server.enums.DiscussCommentTypeEnum;
import com.xiaofu.discuss.server.service.DiscussCommentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author xiaofu
 * @since 2024-03-18
 */
@Service
public class DiscussCommentServiceImpl extends ServiceImpl<DiscussCommentMapper, DiscussComment> implements DiscussCommentService {

    @Override
    public int addDiscussComment(DiscussComment discussComment) {
        return this.baseMapper.insert(discussComment);
    }

    @Override
    public List<DiscussComment> getDiscussComment(Long entityId) {
        return this.lambdaQuery()
                .eq(DiscussComment::getEntityId, entityId)
                .eq(DiscussComment::getEntityType, DiscussCommentTypeEnum.COMMENTS)
                .eq(DiscussComment::getStatus, DiscussCommentStatusEnum.VALID)
                .list();
    }
}
