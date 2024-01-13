package com.xiaofu.subject.infra.basic.service.impl;

import com.xiaofu.subject.infra.basic.entity.SubjectMapping;
import com.xiaofu.subject.infra.basic.mapper.SubjectMappingMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaofu.subject.infra.basic.service.SubjectMappingService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 题目分类关系表 服务实现类
 * </p>
 *
 * @author xiaofu
 * @since 2024-01-13
 */
@Service
public class SubjectMappingServiceImpl extends ServiceImpl<SubjectMappingMapper, SubjectMapping> implements SubjectMappingService {

    @Override
    public List<SubjectMapping> queryLabelIdsByCategoryId(Long categoryId) {
        return this.lambdaQuery()
                .eq(SubjectMapping::getCategoryId, categoryId)
                .list();
    }

    @Override
    public List<SubjectMapping> queryByCategoryIdAndLabelId(Long categoryId, Long labelId) {
        return this.lambdaQuery()
                .eq(SubjectMapping::getCategoryId, categoryId)
                .eq(SubjectMapping::getLabelId, labelId)
                .list();
    }
}
