package com.xiaofu.subject.domain.covert;

import com.xiaofu.subject.domain.entity.SubjectAnswerBO;
import com.xiaofu.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/13 19:01
 */

@Mapper
public interface SubjectRadioConverter {
    // 使用MapStruct框架来进行对象转换
    SubjectRadioConverter INSTANCE = Mappers.getMapper(SubjectRadioConverter.class);

    SubjectRadio covertBoToEntity(SubjectAnswerBO subjectAnswerBO);

    SubjectAnswerBO covertEntityToBo(SubjectRadio subjectRadio);

    List<SubjectAnswerBO> covertEntityToBoList(List<SubjectRadio> subjectRadioList);

}
