package com.xiaofu.subject.infra.basic.service;

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
}
