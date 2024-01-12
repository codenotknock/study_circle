package com.xiaofu.subject.domain.service;

import com.xiaofu.subject.domain.entity.SubjectCategoryBO;

import java.util.List;

public interface SubjectCategoryDomainService {


    /**
     * @des 查询题目分类的大类
     * @param
     * @return List<SubjectCategoryBO>
     */
    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

    /**
     * @des 更新或者新增分类
     * @param
     * @return List<SubjectCategoryBO>
     */
    boolean saveOrUpdate(SubjectCategoryBO subjectCategoryBO);

    boolean delete(Long id);
}
