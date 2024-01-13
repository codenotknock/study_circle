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
    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryBOConverter.INSTANCE.covertBoToEntity(subjectCategoryBO);
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);
        List<SubjectCategoryBO> subjectCategoryBOList = SubjectCategoryBOConverter.INSTANCE.covertEntityToBoList(subjectCategoryList);

        return subjectCategoryBOList;
    }

    @Override
    public boolean saveOrUpdate(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryBOConverter.INSTANCE.covertBoToEntity(subjectCategoryBO);
        return subjectCategoryService.saveOrUpdate(subjectCategory);
    }

    @Override
    public boolean delete(Long id) {
        return subjectCategoryService.removeById(id);
    }
}
