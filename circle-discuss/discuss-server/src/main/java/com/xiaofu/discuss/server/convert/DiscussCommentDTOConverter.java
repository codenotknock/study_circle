package com.xiaofu.discuss.server.convert;

import com.xiaofu.discuss.server.dao.entity.DiscussComment;
import com.xiaofu.discuss.server.dto.DiscussCommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xiaofu
 * @date 2024/3/18 15:31
 * @des
 */
@Mapper
public interface DiscussCommentDTOConverter {
    DiscussCommentDTOConverter INSTANCE =  Mappers.getMapper(DiscussCommentDTOConverter.class);

    DiscussComment convertDtoToEntity(DiscussCommentDTO discussCommentDTO);

    List<DiscussComment> convertDtoToEntityList(List<DiscussCommentDTO> discussCommentDTOList);


    DiscussCommentDTO convertEntityToDto(DiscussComment discussComment);

    List<DiscussCommentDTO> convertEntityToDtoList(List<DiscussComment> discussCommentList);
}
