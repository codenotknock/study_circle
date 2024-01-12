package com.xiaofu.subject.domain.service.impl;

import com.xiaofu.subject.domain.covert.SubjectCategoryBOConverter;
import com.xiaofu.subject.domain.covert.SubjectLabelBOConverter;
import com.xiaofu.subject.domain.entity.SubjectLabelBO;
import com.xiaofu.subject.domain.service.SubjectLabelDomainService;
import com.xiaofu.subject.infra.basic.entity.SubjectLabel;
import com.xiaofu.subject.infra.basic.service.SubjectLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/12 22:48
 * @des
 */
@Service
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Autowired
    private SubjectLabelService subjectLabelService;


    @Override
    public boolean saveOrUpdate(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelBOConverter.INSTANCE.covertBoToLabel(subjectLabelBO);
        return subjectLabelService.saveOrUpdate(subjectLabel);
    }

    @Override
    public boolean delete(Long id) {
        return subjectLabelService.removeById(id);
    }

    @Override
    public List<SubjectLabelBO> queryLabelByCategoryId(Long categoryId) {
        List<SubjectLabel>  subjectLabelList = subjectLabelService.queryLabelByCategoryId(categoryId);
        List<SubjectLabelBO> subjectLabelBOList = SubjectLabelBOConverter.INSTANCE.covertLabelToBoList(subjectLabelList);

        return subjectLabelBOList;
    }
}
