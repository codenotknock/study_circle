package com.xiaofu.subject.application.controller;

import com.xiaofu.subject.infra.basic.entity.SubjectCategory;
import com.xiaofu.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 刷题 controller
 *
 * @author xiaofu
 * @date 2024/1/10 22:10
 */

@RestController
public class SubjectController {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @PostMapping("/test")
    public String test() {
        SubjectCategory subjectCategory = subjectCategoryService.queryById(14L);
        System.out.println(subjectCategory);
        return "test... hello world !!";

    }

}
