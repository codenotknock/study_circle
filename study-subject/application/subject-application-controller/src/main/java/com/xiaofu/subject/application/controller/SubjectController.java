package com.xiaofu.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.base.Preconditions;
import com.xiaofu.common.entitiy.Result;
import com.xiaofu.common.entitiy.page.PageResult;
import com.xiaofu.subject.application.covert.SubjectAnswerDTOConverter;
import com.xiaofu.subject.application.covert.SubjectInfoDTOConverter;
import com.xiaofu.subject.application.dto.SubjectInfoDTO;
import com.xiaofu.subject.domain.entity.SubjectAnswerBO;
import com.xiaofu.subject.domain.entity.SubjectInfoBO;
import com.xiaofu.subject.domain.service.SubjectInfoDomainService;
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
 * 题目 controller
 *
 * @author xiaofu
 * @date 2024/1/13 17:40
 */

@Slf4j
@Api(value = "题目信息", tags = "题目信息")
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectInfoDomainService subjectInfoDomainService;


    @ApiOperation(value = "新增题目")
    @PostMapping(value = {"/add"})
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            // 参数校验
            Preconditions.checkArgument(!subjectInfoDTO.getSubjectName().isEmpty(), "题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(), "题目难度不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(), "题目分数不能为空");
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(subjectInfoDTO.getCategoryIds()), "题目分类不能为空");
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(subjectInfoDTO.getLabelIds()), "题目标签不能为空");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDtoToBo(subjectInfoDTO);
            List<SubjectAnswerBO> subjectAnswerBOList = SubjectAnswerDTOConverter.INSTANCE.convertDtoToBoList(subjectInfoDTO.getOptionList());
            subjectInfoBO.setOptionList(subjectAnswerBOList);

            subjectInfoDomainService.add(subjectInfoBO);
            return Result.ok();
        }catch (Exception e) {
            log.error("SubjectController.add.error:{}", e.getMessage(), e);
            return Result.fail("执行失败");
        }
    }

    @ApiOperation(value = "查询题目列表")
    @PostMapping(value = {"/getSubjectPage"})
    public Result<PageResult<SubjectInfoDTO>> getSubjectPage(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.getSubjectPage.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(), "分类id不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(), "标签id不能为空");


            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDtoToBo(subjectInfoDTO);
            subjectInfoBO.setPageNo(subjectInfoDTO.getPageNo());
            subjectInfoBO.setPageSize(subjectInfoDTO.getPageSize());
            PageResult<SubjectInfoBO> infoBOPageResult = subjectInfoDomainService.getSubjectPage(subjectInfoBO);
            if (null == infoBOPageResult) {
                return Result.ok(new PageResult<>());
            }

            List<SubjectInfoDTO> records = SubjectInfoDTOConverter.INSTANCE.convertBoToDtoList(infoBOPageResult.getResult());
            return Result.ok(new PageResult<>(records));
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(), e);
            return Result.fail("分页查询题目失败");
        }
    }


    @ApiOperation(value = "查询题目信息")
        @PostMapping("/querySubjectInfo")
    public Result<SubjectInfoDTO> querySubjectInfo(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.querySubjectInfo.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkNotNull(subjectInfoDTO.getId(), "题目id不能为空");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDtoToBo(subjectInfoDTO);
            SubjectInfoBO infoBO = subjectInfoDomainService.querySubjectInfo(subjectInfoBO);
            if (null == infoBO) {
                return Result.ok();
            }
            SubjectInfoDTO infoDTO = SubjectInfoDTOConverter.INSTANCE.convertBoToDto(infoBO);
            return Result.ok(infoDTO);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(), e);
            return Result.fail("查询题目详情失败");
        }
    }
}
