package com.xiaofu.subject.application.covert;

import com.xiaofu.subject.application.dto.SubjectLikedDTO;
import com.xiaofu.subject.domain.entity.SubjectLikedBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/28 3:06
 * @des
 */
@Mapper
public interface SubjectLikedDTOConverter {
    SubjectLikedDTOConverter INSTANCE = Mappers.getMapper(SubjectLikedDTOConverter.class);

    SubjectLikedBO convertDtoToBo(SubjectLikedDTO subjectLikedDTO);

    List<SubjectLikedDTO> convertBoToDtoList(List<SubjectLikedBO> subjectLikedBOList);
}
