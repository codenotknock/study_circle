package com.xiaofu.subject.domain.service.impl;

import com.xiaofu.subject.domain.covert.SubjectLabelBOConverter;
import com.xiaofu.subject.domain.entity.SubjectLabelBO;
import com.xiaofu.subject.domain.service.SubjectLabelDomainService;
import com.xiaofu.subject.infra.basic.entity.SubjectLabel;
import com.xiaofu.subject.infra.basic.entity.SubjectMapping;
import com.xiaofu.subject.infra.basic.service.SubjectLabelService;
import com.xiaofu.subject.infra.basic.service.SubjectMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaofu
 * @date 2024/1/12 22:48
 * @des
 */
@Service
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Autowired
    private SubjectLabelService subjectLabelService;

    @Autowired
    private SubjectMappingService subjectMappingService;

    @Override
    public boolean saveOrUpdate(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelBOConverter.INSTANCE.covertBoToEntity(subjectLabelBO);
        return subjectLabelService.saveOrUpdate(subjectLabel);
    }

    @Override
    public boolean delete(Long id) {
        return subjectLabelService.removeById(id);
    }

    @Override
    public List<SubjectLabelBO> queryLabelByCategoryId(Long categoryId) {
        // 查询出该分类下题目涉及到的所有标签
        List<SubjectMapping> subjectMappingList = subjectMappingService.queryLabelIdsByCategoryId(categoryId);
        List<Long> labelIds = subjectMappingList.stream().map(SubjectMapping::getLabelId).distinct().collect(Collectors.toList());
        List<SubjectLabel> subjectLabelList = subjectLabelService.listByIds(labelIds);
        List<SubjectLabelBO> subjectLabelBOList = SubjectLabelBOConverter.INSTANCE.covertEntityToBoList(subjectLabelList);

        return subjectLabelBOList;
    }
}
