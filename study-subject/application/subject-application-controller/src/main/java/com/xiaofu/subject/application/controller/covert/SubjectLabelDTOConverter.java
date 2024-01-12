package com.xiaofu.subject.application.controller.covert;

import com.xiaofu.subject.application.controller.dto.SubjectLabelDTO;
import com.xiaofu.subject.domain.entity.SubjectLabelBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/12 22:50
 */

@Mapper
public interface SubjectLabelDTOConverter {
    // 使用MapStruct框架来进行对象转换
    SubjectLabelDTOConverter INSTANCE = Mappers.getMapper(SubjectLabelDTOConverter.class);

    SubjectLabelBO convertDtoToBo(SubjectLabelDTO subjectLabelDTO);

    List<SubjectLabelDTO> convertBoToDtoList(List<SubjectLabelBO> subjectLabelBOList);

}
