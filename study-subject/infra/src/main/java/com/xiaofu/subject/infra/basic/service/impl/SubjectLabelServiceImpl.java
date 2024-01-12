package com.xiaofu.subject.infra.basic.service.impl;


import com.xiaofu.subject.infra.basic.entity.SubjectLabel;
import com.xiaofu.subject.infra.basic.mapper.SubjectLabelMapper;
import com.xiaofu.subject.infra.basic.service.SubjectLabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 题目标签表 服务实现类
 * </p>
 *
 * @author xiaofu
 * @since 2024-01-12
 */
@Service
public class SubjectLabelServiceImpl extends ServiceImpl<SubjectLabelMapper, SubjectLabel> implements SubjectLabelService {

    @Override
    public List<SubjectLabel> queryLabelByCategoryId(Long categoryId) {
        return this.lambdaQuery()
                .eq(SubjectLabel::getCategoryId, categoryId)
                .list();
    }
}
