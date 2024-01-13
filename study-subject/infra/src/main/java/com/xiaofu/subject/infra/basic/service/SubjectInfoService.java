package com.xiaofu.subject.infra.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaofu.subject.infra.basic.entity.SubjectInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 题目信息表 服务类
 * </p>
 *
 * @author xiaofu
 * @since 2024-01-12
 */
public interface SubjectInfoService extends IService<SubjectInfo> {


    IPage<SubjectInfo> queryPageByIds(Page<SubjectInfo> page, List<Long> ids);
}
