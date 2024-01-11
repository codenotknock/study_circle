package com.xiaofu.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaofu.subject.infra.basic.entity.SubjectCategory;
import com.xiaofu.subject.infra.basic.mapper.SubjectCategoryMapper;
import com.xiaofu.subject.infra.basic.service.SubjectCategoryService;
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
    @Resource
    private SubjectCategoryMapper subjectCategoryMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectCategory queryById(Long id) {
        return this.subjectCategoryMapper.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectCategory insert(SubjectCategory subjectCategory) {
        this.subjectCategoryMapper.insert(subjectCategory);
        return subjectCategory;
    }

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectCategory update(SubjectCategory subjectCategory) {
        this.subjectCategoryMapper.update(subjectCategory);
        return this.queryById(subjectCategory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectCategoryMapper.deleteById(id) > 0;
    }

    @Override
    public List<SubjectCategory> queryPrimaryCategory() {
        return this.lambdaQuery()
                .eq(SubjectCategory::getParentId, 0)
                .list();
    }
}
