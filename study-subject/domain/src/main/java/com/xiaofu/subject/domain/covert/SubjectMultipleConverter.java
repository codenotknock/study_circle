package com.xiaofu.subject.domain.covert;

import com.xiaofu.subject.domain.entity.SubjectAnswerBO;
import com.xiaofu.subject.infra.basic.entity.SubjectMultiple;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/13 20:55
 * @des
 */
@Mapper
public interface SubjectMultipleConverter {

    SubjectMultipleConverter INSTANCE= Mappers.getMapper(SubjectMultipleConverter.class);

    SubjectMultiple covertBoToEntity(SubjectAnswerBO subjectAnswerBO);

    List<SubjectAnswerBO> covertEntityToBoList(List<SubjectMultiple> subjectMultipleList);


}
