package com.xiaofu.subject.infra.basic.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaofu.subject.infra.basic.entity.SubjectLabel;

import java.util.List;

/**
 * <p>
 * 题目标签表 服务类
 * </p>
 *
 * @author xiaofu
 * @since 2024-01-12
 */
public interface SubjectLabelService extends IService<SubjectLabel> {

    List<SubjectLabel> queryByCategoryId(Long categoryId);
}
