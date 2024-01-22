package com.xiaofu.subject.application.covert;

import com.xiaofu.subject.application.dto.SubjectCategoryDTO;
import com.xiaofu.subject.domain.entity.SubjectCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/11 22:18
 */

@Mapper
public interface SubjectCategoryDTOConverter {
    // 使用MapStruct框架来进行对象转换
    SubjectCategoryDTOConverter  INSTANCE = Mappers.getMapper(SubjectCategoryDTOConverter.class);

    SubjectCategoryBO convertDtoToBo(SubjectCategoryDTO subjectCategoryDTO);

    List<SubjectCategoryDTO> convertBoToDtoList(List<SubjectCategoryBO> subjectCategoryBOList);

}
