package com.xiaofu.subject.domain.service;

import com.xiaofu.subject.common.entity.page.PageResult;
import com.xiaofu.subject.domain.entity.SubjectInfoBO;

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
}
