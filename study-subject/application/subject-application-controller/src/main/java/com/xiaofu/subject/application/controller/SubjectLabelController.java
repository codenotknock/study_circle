package com.xiaofu.subject.application.controller;

import com.google.common.base.Preconditions;
import com.xiaofu.subject.application.controller.covert.SubjectLabelDTOConverter;
import com.xiaofu.subject.application.controller.dto.SubjectLabelDTO;
import com.xiaofu.subject.common.entity.Result;
import com.xiaofu.subject.domain.entity.SubjectLabelBO;
import com.xiaofu.subject.domain.service.SubjectLabelDomainService;
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
 * @date 2024/1/12 22:43
 * @des 题目分类
 */

@Slf4j
@Api(value = "题目标签", tags = "题目标签")
@RestController
@RequestMapping("/subject/label")
public class SubjectLabelController {
    @Autowired
    SubjectLabelDomainService subjectLabelDomainService;

    @ApiOperation(value = "新增/编辑题目标签")
    @PostMapping(value = {"/update", "/add"})
    public Result<Boolean> addOrUpdate(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            // 参数校验
            Preconditions.checkArgument(!subjectLabelDTO.getLabelName().isEmpty(), "标签名称不能为空");
            Preconditions.checkNotNull(subjectLabelDTO.getSortNum(), "标签顺序不能为空");

            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.convertDtoToBo(subjectLabelDTO);
            boolean res = subjectLabelDomainService.saveOrUpdate(subjectLabelBO);
            return Result.ok(res);
        }catch (Exception e) {
            log.error("SubjectLabelController.addOrUpdate.error:{}", e.getMessage(), e);
            return Result.fail("执行失败");
        }
    }
    @ApiOperation(value = "删除标签")
    @PostMapping(value = {"delete"})
    public Result<Boolean> delete(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            // 参数校验
            Preconditions.checkNotNull(subjectLabelDTO.getId(), "id不能为空");

            boolean res = subjectLabelDomainService.delete(subjectLabelDTO.getId());
            return Result.ok(res);
        } catch (Exception e) {
            log.error("SubjectLabelController.delete.error:{}", e.getMessage(), e);
            return Result.fail("执行失败");
        }
    }

    @ApiOperation(value = "根据分类查询标签")
    @PostMapping(value = {"queryLabelByCategoryId"})
    public Result<List<SubjectLabelDTO>> queryLabelByCategoryId(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            // 参数校验
            Preconditions.checkNotNull(subjectLabelDTO.getCategoryId(), "分类id不能为空");

            List<SubjectLabelBO> subjectLabelBOList = subjectLabelDomainService.queryLabelByCategoryId(subjectLabelDTO.getCategoryId());
            List<SubjectLabelDTO> subjectLabelDTOList = SubjectLabelDTOConverter.INSTANCE.convertBoToDtoList(subjectLabelBOList);
            return Result.ok(subjectLabelDTOList);
        } catch (Exception e) {
            log.error("SubjectLabelController.queryLabelByCategoryId.error:{}", e.getMessage(), e);
            return Result.fail("执行失败");
        }
    }

}
