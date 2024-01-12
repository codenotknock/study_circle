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
    // TODO 后期要进行判断  引用该分类的题目需要同步判断  比如更新操作：对应的题目列表都进行更新   删除操作：如果有题目引用该分类不能删除 等等逻辑
    @Autowired
    SubjectCategoryDomainService subjectCategoryDomainService;

    @ApiOperation(value = "新增/编辑题目分类")
    @PostMapping(value = {"/update", "/add"})
    public Result<Boolean> addOrUpdate(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            // 参数校验
            Preconditions.checkArgument(!subjectCategoryDTO.getCategoryName().isEmpty(), "分类名称不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(), "分类类型不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(), "分类父级id不能为空");

            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertDtoToBo(subjectCategoryDTO);
            boolean res = subjectCategoryDomainService.saveOrUpdate(subjectCategoryBO);
            return Result.ok(res);
        }catch (Exception e) {
            log.error("SubjectCategoryController.addOrUpdate.error:{}", e.getMessage(), e);
            return Result.fail("执行失败");
        }
    }

    @ApiOperation(value = "查询题目分类")
    @PostMapping(value = {"/queryPrimaryCategory", "/queryCategoryByPrimary"})
    public Result<List<SubjectCategoryDTO>> queryPrimaryCategory(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            // 参数校验
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(), "分类类型不能为空");

            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertDtoToBo(subjectCategoryDTO);
            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryCategory(subjectCategoryBO);
            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE.convertBoToDtoList(subjectCategoryBOList);
            return Result.ok(subjectCategoryDTOList);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryPrimaryCategory.error:{}", e.getMessage(), e);
            return Result.fail("执行失败");
        }
    }

    @ApiOperation(value = "删除分类")
    @PostMapping(value = {"delete"})
    public Result<Boolean> delete(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            // 参数校验
            Preconditions.checkNotNull(subjectCategoryDTO.getId(), "id不能为空");

            boolean res = subjectCategoryDomainService.delete(subjectCategoryDTO.getId());
            return Result.ok(res);
        } catch (Exception e) {
            log.error("SubjectCategoryController.delete.error:{}", e.getMessage(), e);
            return Result.fail("执行失败");
        }
    }

}
