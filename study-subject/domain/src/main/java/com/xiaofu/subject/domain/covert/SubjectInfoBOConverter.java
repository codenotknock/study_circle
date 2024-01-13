package com.xiaofu.subject.domain.covert;

import com.xiaofu.subject.domain.entity.SubjectInfoBO;
import com.xiaofu.subject.infra.basic.entity.SubjectInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/11 22:18
 */

@Mapper
public interface SubjectInfoBOConverter {
    // 使用MapStruct框架来进行对象转换
    SubjectInfoBOConverter  INSTANCE = Mappers.getMapper(SubjectInfoBOConverter.class);

    SubjectInfo covertBoToInfo(SubjectInfoBO subjectInfoBO);

    List<SubjectInfoBO> covertInfoToBoList (List<SubjectInfo> subjectInfoList);

}
