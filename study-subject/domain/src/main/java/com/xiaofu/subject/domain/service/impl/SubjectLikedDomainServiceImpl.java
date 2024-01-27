package com.xiaofu.subject.domain.service.impl;

import com.xiaofu.subject.common.constants.SubjectConstant;
import com.xiaofu.subject.common.enums.SubjectLikedStatusEnum;
import com.xiaofu.subject.domain.covert.SubjectLikedBOConverter;
import com.xiaofu.subject.domain.entity.SubjectLikedBO;
import com.xiaofu.subject.domain.redis.RedisUtil;
import com.xiaofu.subject.domain.service.SubjectLikedDomainService;
import com.xiaofu.subject.infra.basic.entity.SubjectLiked;
import com.xiaofu.subject.infra.basic.service.SubjectLikedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author xiaofu
 * @date 2024/1/28 2:18
 * @des
 */

@Service
public class SubjectLikedDomainServiceImpl implements SubjectLikedDomainService {
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private SubjectLikedService subjectLikedService;

    @Override
    public void add(SubjectLikedBO subjectLikedBO) {
        String key = subjectLikedBO.getSubjectId() + ":" + subjectLikedBO.getLikeUserId();
        String detailKey = SubjectConstant.SUBJECT_LIKED_DETAIL_KEY + "." + subjectLikedBO.getSubjectId() + "." +  subjectLikedBO.getLikeUserId();
        String countKey = SubjectConstant.SUBJECT_LIKED_COUNT_KEY + "." + subjectLikedBO.getSubjectId();
        redisUtil.putHash(SubjectConstant.SUBJECT_LIKED_KEY, key, subjectLikedBO.getStatus());
        if (subjectLikedBO.getStatus() == SubjectLikedStatusEnum.LIKED.getCode()) {
            redisUtil.increment(countKey, 1);
            redisUtil.set(detailKey, "1");
        } else {
            Integer count = redisUtil.getInt(countKey);
            if (Objects.isNull(count) || count <= 0) {
                return;
            }
            redisUtil.increment(countKey, -1);
            redisUtil.del(detailKey);
        }
    }

    @Override
    public Boolean isLiked(String subjectId, String userId) {
        return redisUtil.exist(SubjectConstant.SUBJECT_LIKED_DETAIL_KEY + "." + subjectId + userId);
    }

    @Override
    public Integer getLikedCount(String subjectId) {
        Integer count = redisUtil.getInt(SubjectConstant.SUBJECT_LIKED_COUNT_KEY + "." + subjectId);
        if (Objects.nonNull(count) && count > 0) {
            return count;
        }
        return 0;
    }

    @Override
    public Boolean update(SubjectLikedBO subjectLikedBO) {
        SubjectLiked subjectLiked = SubjectLikedBOConverter.INSTANCE.convertBoToEntity(subjectLikedBO);
        return subjectLikedService.updateById(subjectLiked);
    }

    @Override
    public Boolean delete(SubjectLikedBO subjectLikedBO) {
        SubjectLiked subjectLiked = SubjectLikedBOConverter.INSTANCE.convertBoToEntity(subjectLikedBO);
        return subjectLikedService.removeById(subjectLiked);
    }
}
