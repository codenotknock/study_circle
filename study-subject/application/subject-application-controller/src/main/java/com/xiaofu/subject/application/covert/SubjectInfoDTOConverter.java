package com.xiaofu.subject.application.covert;

import com.xiaofu.subject.application.dto.SubjectInfoDTO;
import com.xiaofu.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/13 17:44
 * @des
 */
@Mapper
public interface SubjectInfoDTOConverter {
    SubjectInfoDTOConverter INSTANCE = Mappers.getMapper(SubjectInfoDTOConverter.class);

    SubjectInfoBO convertDtoToBo(SubjectInfoDTO subjectInfoDTO);

    SubjectInfoDTO convertBoToDto(SubjectInfoBO subjectInfoBO);

    List<SubjectInfoDTO> convertBoToDtoList (List<SubjectInfoBO> subjectInfoBOList);
}
