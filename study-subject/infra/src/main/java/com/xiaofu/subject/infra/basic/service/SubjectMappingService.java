package com.xiaofu.subject.infra.basic.service;

import com.xiaofu.subject.infra.basic.entity.SubjectMapping;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 题目分类关系表 服务类
 * </p>
 *
 * @author xiaofu
 * @since 2024-01-13
 */
public interface SubjectMappingService extends IService<SubjectMapping> {

    List<SubjectMapping> queryLabelIdsByCategoryId(Long categoryId);
}
