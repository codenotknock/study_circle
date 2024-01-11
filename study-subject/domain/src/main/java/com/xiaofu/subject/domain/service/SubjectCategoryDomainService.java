package com.xiaofu.subject.domain.service;

import com.xiaofu.subject.domain.entity.SubjectCategoryBO;

import java.util.List;

public interface SubjectCategoryDomainService {

    void add(SubjectCategoryBO subjectCategoryBO);

    /**
     * @des 查询题目分类的大类
     * @param
     * @return
     */

    List<SubjectCategoryBO> queryPrimaryCategory();
}
