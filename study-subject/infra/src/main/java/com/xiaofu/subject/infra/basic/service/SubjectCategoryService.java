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
     * 查询题目分类 ： 大类
     * @return
     */
    List<SubjectCategory> queryCategory(SubjectCategory subjectCategory);
}
