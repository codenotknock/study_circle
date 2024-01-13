package com.xiaofu.subject.domain.covert;

import com.xiaofu.subject.domain.entity.SubjectCategoryBO;
import com.xiaofu.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/11 21:58
 */

@Mapper
public interface SubjectCategoryBOConverter {
    // 使用MapStruct框架来进行对象转换
    SubjectCategoryBOConverter INSTANCE = Mappers.getMapper(SubjectCategoryBOConverter.class);

    SubjectCategory covertBoToEntity(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryBO> covertEntityToBoList(List<SubjectCategory> subjectCategoryList);
}
