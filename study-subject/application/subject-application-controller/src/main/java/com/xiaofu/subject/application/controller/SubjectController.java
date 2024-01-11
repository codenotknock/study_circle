package com.xiaofu.subject.application.controller;

import com.xiaofu.subject.infra.basic.entity.SubjectCategory;
import com.xiaofu.subject.infra.basic.service.SubjectCategoryService;

/**
 * 刷题 controller
 *
 * @author xiaofu
 * @date 2024/1/10 22:10
 */

public class SubjectController {


    private SubjectCategoryService subjectCategoryService;

    public String test() {
        SubjectCategory subjectCategory = subjectCategoryService.queryById(14L);
        System.out.println(subjectCategory);
        return "test... hello world !!";

    }

}
