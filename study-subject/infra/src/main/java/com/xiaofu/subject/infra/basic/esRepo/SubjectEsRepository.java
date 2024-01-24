package com.xiaofu.subject.infra.basic.esRepo;

import com.xiaofu.subject.infra.basic.entity.SubjectInfoEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author xiaofu
 * @date 2024/1/25 0:16
 * @des
 */
@Component
public interface SubjectEsRepository extends ElasticsearchRepository<SubjectInfoEs, Long> {
}
