package com.xiaofu.subject.domain.service;

import com.xiaofu.subject.domain.entity.SubjectLabelBO;

import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/12 22:46
 * @des
 */
public interface SubjectLabelDomainService {

    boolean saveOrUpdate(SubjectLabelBO subjectLabelBO);

    boolean delete(Long id);

    List<SubjectLabelBO> queryLabelByCategoryId(Long categoryId);
}
