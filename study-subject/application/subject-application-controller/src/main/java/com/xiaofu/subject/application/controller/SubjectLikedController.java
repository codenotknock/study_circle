package com.xiaofu.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.xiaofu.common.entitiy.Result;
import com.xiaofu.common.entitiy.page.PageResult;
import com.xiaofu.subject.application.covert.SubjectLikedDTOConverter;
import com.xiaofu.subject.application.dto.SubjectLikedDTO;
import com.xiaofu.subject.common.util.LoginUtil;
import com.xiaofu.subject.domain.entity.SubjectLikedBO;
import com.xiaofu.subject.domain.service.SubjectLikedDomainService;
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
 * @date 2024/1/28 3:04
 * @des
 */
@RestController
@RequestMapping("/subjectLiked/")
@Slf4j
public class SubjectLikedController {

    @Autowired
    private SubjectLikedDomainService subjectLikedDomainService;


    @ApiOperation(value = "新增题目点赞")
    @RequestMapping("add")
    public Result<Boolean> add(@RequestBody SubjectLikedDTO subjectLikedDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLikedController.add.dto:{}", JSON.toJSONString(subjectLikedDTO));
            }
            Preconditions.checkNotNull(subjectLikedDTO.getSubjectId(), "题目id不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getStatus(), "点赞状态不能为空");
            String loginId = LoginUtil.getLoginId();
            subjectLikedDTO.setLikeUserId(loginId);
            Preconditions.checkNotNull(subjectLikedDTO.getLikeUserId(), "点赞人不能为空");
            SubjectLikedBO SubjectLikedBO = SubjectLikedDTOConverter.INSTANCE.convertDtoToBo(subjectLikedDTO);
            subjectLikedDomainService.add(SubjectLikedBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectLikedController.register.error:{}", e.getMessage(), e);
            return Result.fail("新增题目点赞表失败");
        }

    }


    @ApiOperation(value = "修改题目点赞")
    @RequestMapping("update")
    public Result<Boolean> update(@RequestBody SubjectLikedDTO subjectLikedDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLikedController.update.dto:{}", JSON.toJSONString(subjectLikedDTO));
            }
            Preconditions.checkNotNull(subjectLikedDTO.getId(), "主键不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getSubjectId(), "题目id不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getLikeUserId(), "点赞人id不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getStatus(), "点赞状态 1点赞 0不点赞不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getCreatedBy(), "创建人不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getCreatedTime(), "创建时间不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getUpdateBy(), "修改人不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getUpdateTime(), "修改时间不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getIsDeleted(), "不能为空");
            SubjectLikedBO subjectLikedBO = SubjectLikedDTOConverter.INSTANCE.convertDtoToBo(subjectLikedDTO);
            return Result.ok(subjectLikedDomainService.update(subjectLikedBO));
        } catch (Exception e) {
            log.error("SubjectLikedController.update.error:{}", e.getMessage(), e);
            return Result.fail("更新题目点赞表信息失败");
        }

    }


    @ApiOperation(value = "删除题目点赞")
    @RequestMapping("delete")
    public Result<Boolean> delete(@RequestBody SubjectLikedDTO subjectLikedDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLikedController.delete.dto:{}", JSON.toJSONString(subjectLikedDTO));
            }
            Preconditions.checkNotNull(subjectLikedDTO.getId(), "主键不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getSubjectId(), "题目id不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getLikeUserId(), "点赞人id不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getStatus(), "点赞状态 1点赞 0不点赞不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getCreatedBy(), "创建人不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getCreatedTime(), "创建时间不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getUpdateBy(), "修改人不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getUpdateTime(), "修改时间不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getIsDeleted(), "不能为空");
            SubjectLikedBO subjectLikedBO = SubjectLikedDTOConverter.INSTANCE.convertDtoToBo(subjectLikedDTO);
            return Result.ok(subjectLikedDomainService.delete(subjectLikedBO));
        } catch (Exception e) {
            log.error("SubjectLikedController.delete.error:{}", e.getMessage(), e);
            return Result.fail("删除题目点赞表信息失败");
        }
    }


    @ApiOperation(value = "查询我的点赞列表")
    @PostMapping("/getSubjectLikedPage")
    public Result<PageResult<SubjectLikedDTO>> getSubjectLikedPage(@RequestBody SubjectLikedDTO subjectLikedDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.getSubjectLikedPage.dto:{}", JSON.toJSONString(subjectLikedDTO));
            }
            SubjectLikedBO subjectLikedBO = SubjectLikedDTOConverter.INSTANCE.convertDtoToBo(subjectLikedDTO);
            subjectLikedBO.setPageNo(subjectLikedDTO.getPageNo());
            subjectLikedBO.setPageSize(subjectLikedDTO.getPageSize());
            PageResult<SubjectLikedBO> boPageResult = subjectLikedDomainService.getSubjectLikedPage(subjectLikedBO);
            List<SubjectLikedDTO> subjectLikedDTOList = SubjectLikedDTOConverter.INSTANCE.convertBoToDtoList(boPageResult.getResult());
            PageResult<SubjectLikedDTO> subjectLikedDTOPageResult = new PageResult<>();
            subjectLikedDTOPageResult.setPageSize(subjectLikedDTO.getPageSize());
            subjectLikedDTOPageResult.setPageNo(subjectLikedDTO.getPageNo());
            subjectLikedDTOPageResult.setRecords(subjectLikedDTOList);
            return Result.ok(subjectLikedDTOPageResult);
        } catch (Exception e) {
            log.error("SubjectCategoryController.getSubjectLikedPage.error:{}", e.getMessage(), e);
            return Result.fail("分页查询我的点赞失败");


        }
    }
}
