package com.xiaofu.subject.domain.service;

import com.xiaofu.common.entitiy.page.PageResult;
import com.xiaofu.subject.domain.entity.SubjectInfoBO;
import com.xiaofu.subject.infra.basic.entity.SubjectInfoEs;

import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/13 18:09
 * @des
 */
public interface SubjectInfoDomainService {

    /**
     * 新增题目
     */
    void add(SubjectInfoBO subjectInfoBO);


    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);

    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);

    PageResult<SubjectInfoEs> getSubjectPageBySearch(SubjectInfoBO subjectInfoBO);

    List<SubjectInfoBO> getContributeList();
}
