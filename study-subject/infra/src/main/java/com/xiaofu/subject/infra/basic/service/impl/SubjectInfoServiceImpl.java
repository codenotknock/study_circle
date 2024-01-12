package com.xiaofu.subject.infra.basic.service.impl;

import com.xiaofu.subject.infra.basic.entity.SubjectInfo;
import com.xiaofu.subject.infra.basic.mapper.SubjectInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaofu.subject.infra.basic.service.SubjectInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 题目信息表 服务实现类
 * </p>
 *
 * @author xiaofu
 * @since 2024-01-12
 */
@Service
public class SubjectInfoServiceImpl extends ServiceImpl<SubjectInfoMapper, SubjectInfo> implements SubjectInfoService {

}
