package com.xiaofu.subject.domain.covert;

import com.xiaofu.subject.domain.entity.SubjectLikedBO;
import com.xiaofu.subject.infra.basic.entity.SubjectLiked;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xiaofu
 * @date 2024/1/28 2:51
 * @des
 */
@Mapper
public interface SubjectLikedBOConverter {
    SubjectLikedBOConverter INSTANCE= Mappers.getMapper(SubjectLikedBOConverter.class);

    SubjectLiked convertBoToEntity(SubjectLikedBO subjectLikedBO);
}
