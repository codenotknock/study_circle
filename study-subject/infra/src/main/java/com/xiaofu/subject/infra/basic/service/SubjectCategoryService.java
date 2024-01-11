package com.xiaofu.subject.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaofu.subject.infra.basic.entity.SubjectCategory;

import java.util.List;

/**
 * 题目分类表(SubjectCategory)表服务接口
 *
 * @author xiaofu
 * @since 2024-01-10 22:58:28
 */
public interface SubjectCategoryService extends IService<SubjectCategory> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectCategory queryById(Long id);

    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    SubjectCategory insert(SubjectCategory subjectCategory);

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    SubjectCategory update(SubjectCategory subjectCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);


    /**
     * 查询题目分类 ： 大类
     * @return
     */
    List<SubjectCategory> queryPrimaryCategory();
}
