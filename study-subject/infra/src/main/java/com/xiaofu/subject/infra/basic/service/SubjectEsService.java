package com.xiaofu.subject.infra.basic.service;

import com.xiaofu.common.entitiy.page.PageResult;
import com.xiaofu.subject.infra.basic.entity.SubjectInfoEs;

/**
 * @author xiaofu
 * @date 2024/1/25 0:20
 * @des
 */
public interface SubjectEsService {

    void createIndex();

    void getDocs();

    void find();

    void search();

    boolean insert(SubjectInfoEs subjectInfoEs);

    PageResult<SubjectInfoEs> querySubjectList(SubjectInfoEs subjectInfoEs);
}
