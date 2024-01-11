package com.xiaofu.subject.application.controller;

import com.xiaofu.subject.application.controller.covert.SubjectCategoryDTOConverter;
import com.xiaofu.subject.application.controller.dto.SubjectCategoryDTO;
import com.xiaofu.subject.common.entity.Result;
import com.xiaofu.subject.domain.entity.SubjectCategoryBO;
import com.xiaofu.subject.domain.service.SubjectCategoryDomainService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaofu
 * @date 2024/1/11 22:33
 * @des 题目分类
 */

@Api(value = "题目分类", tags = "题目分类")
@RestController
@RequestMapping("/subject/category")
public class SubjectCategoryController {

    @Autowired
    SubjectCategoryDomainService subjectCategoryDomainService;

    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.covertDTOToBO(subjectCategoryDTO);
            subjectCategoryDomainService.add(subjectCategoryBO);
            return Result.ok(Boolean.TRUE);
        }catch (Throwable e) {
            throw e;
        }

    }

}
