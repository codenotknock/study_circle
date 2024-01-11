package com.xiaofu.subject.application.controller;

import com.google.common.base.Preconditions;
import com.xiaofu.subject.application.controller.covert.SubjectCategoryDTOConverter;
import com.xiaofu.subject.application.controller.dto.SubjectCategoryDTO;
import com.xiaofu.subject.common.entity.Result;
import com.xiaofu.subject.domain.entity.SubjectCategoryBO;
import com.xiaofu.subject.domain.service.SubjectCategoryDomainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/11 22:33
 * @des 题目分类
 */

@Slf4j
@Api(value = "题目分类", tags = "题目分类")
@RestController
@RequestMapping("/subject/category")
public class SubjectCategoryController {

    @Autowired
    SubjectCategoryDomainService subjectCategoryDomainService;

    @ApiOperation(value = "添加题目分类")
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            // 参数校验
            Preconditions.checkArgument(subjectCategoryDTO.getCategoryName().isEmpty(), "分类名称不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(), "分类类型不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(), "分类父级id不能为空");

            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertDtoToBo(subjectCategoryDTO);
            subjectCategoryDomainService.add(subjectCategoryBO);
            return Result.ok(Boolean.TRUE);
        }catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        }
    }

    @ApiOperation(value = "查询题目分类")
    @PostMapping("/queryPrimaryCategory")
    public Result<List<SubjectCategoryDTO>> queryPrimaryCategory() {
        try {
            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryPrimaryCategory();
            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE.convertBoToDtoList(subjectCategoryBOList);
            return Result.ok(subjectCategoryDTOList);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryPrimaryCategory.error:{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        }
    }



}
