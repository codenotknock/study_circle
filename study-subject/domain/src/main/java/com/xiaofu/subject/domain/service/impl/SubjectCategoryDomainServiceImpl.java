package com.xiaofu.subject.domain.service.impl;

import com.xiaofu.subject.domain.covert.SubjectCategoryBOConverter;
import com.xiaofu.subject.domain.entity.SubjectCategoryBO;
import com.xiaofu.subject.domain.service.SubjectCategoryDomainService;
import com.xiaofu.subject.infra.basic.entity.SubjectCategory;
import com.xiaofu.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/11 22:02
 */
@Service
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Autowired
    private SubjectCategoryService subjectCategoryService;

    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryBOConverter.INSTANCE.covertBoToCategory(subjectCategoryBO);
        subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public List<SubjectCategoryBO> queryPrimaryCategory() {
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryPrimaryCategory();
        List<SubjectCategoryBO> subjectCategoryBOList = SubjectCategoryBOConverter.INSTANCE.covertCategoryToBoList(subjectCategoryList);

        return subjectCategoryBOList;
    }
}
