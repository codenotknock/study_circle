package com.xiaofu.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaofu.subject.infra.basic.entity.SubjectCategory;
import com.xiaofu.subject.infra.basic.mapper.SubjectCategoryMapper;
import com.xiaofu.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 题目分类表(SubjectCategory)表服务实现类
 *
 * @author xiaofu
 * @since 2024-01-10 22:56:31
 */
@Service("subjectCategoryService")
public class SubjectCategoryServiceImpl extends ServiceImpl<SubjectCategoryMapper,SubjectCategory> implements SubjectCategoryService {

    @Override
    public List<SubjectCategory> queryCategory(SubjectCategory subjectCategory) {
        if (subjectCategory.getParentId() == null) {
            subjectCategory.setParentId(0L);
        }
        return this.lambdaQuery()
                .eq(SubjectCategory::getParentId, subjectCategory.getParentId())
                .eq(SubjectCategory::getCategoryType, subjectCategory.getCategoryType())
                .list();
    }

    @Override
    public Integer querySubjectCount(Long id) {
        return this.getBaseMapper().querySubjectCount(id);
    }


}
