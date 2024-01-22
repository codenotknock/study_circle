package com.xiaofu.subject.application.covert;

import com.xiaofu.subject.application.dto.SubjectAnswerDTO;
import com.xiaofu.subject.domain.entity.SubjectAnswerBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/13 17:44
 * @des
 */
@Mapper
public interface SubjectAnswerDTOConverter {
    SubjectAnswerDTOConverter INSTANCE = Mappers.getMapper(SubjectAnswerDTOConverter.class);

    SubjectAnswerBO convertDtoToBo(SubjectAnswerDTO subjectAnswerDTO);
    List<SubjectAnswerBO> convertDtoToBoList(List<SubjectAnswerDTO> subjectAnswerDTOList);

    List<SubjectAnswerDTO> convertBoToDtoList (List<SubjectAnswerBO> subjectAnswerBOList);
}
