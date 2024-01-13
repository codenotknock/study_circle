package com.xiaofu.subject.domain.covert;

import com.xiaofu.subject.domain.entity.SubjectAnswerBO;
import com.xiaofu.subject.infra.basic.entity.SubjectJudge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/13 20:55
 * @des
 */
@Mapper
public interface SubjectJudgeConverter {

    SubjectJudgeConverter INSTANCE= Mappers.getMapper(SubjectJudgeConverter.class);

    SubjectJudge covertBoToEntity(SubjectAnswerBO subjectAnswerBO);

    SubjectAnswerBO covertEntityToBo(SubjectJudge subjectJudge);

    List<SubjectAnswerBO> covertEntityToBoList(List<SubjectJudge> subjectJudgeList);


}
