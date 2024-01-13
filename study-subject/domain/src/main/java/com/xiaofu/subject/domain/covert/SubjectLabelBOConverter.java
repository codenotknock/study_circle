package com.xiaofu.subject.domain.covert;

import com.xiaofu.subject.domain.entity.SubjectLabelBO;
import com.xiaofu.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/12 22:36
 * @des
 */
@Mapper
public interface SubjectLabelBOConverter {

    SubjectLabelBOConverter INSTANCE = Mappers.getMapper(SubjectLabelBOConverter.class);

    SubjectLabel covertBoToEntity(SubjectLabelBO subjectLabelBO);

    List<SubjectLabelBO> covertEntityToBoList(List<SubjectLabel> subjectLabelList);

}
