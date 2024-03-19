package com.xiaofu.discuss.server.convert;

import com.xiaofu.discuss.server.dao.entity.DiscussPost;
import com.xiaofu.discuss.server.dto.DiscussPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xiaofu
 * @date 2024/3/18 15:31
 * @des
 */
@Mapper
public interface DiscussPostDTOConverter {
    DiscussPostDTOConverter INSTANCE =  Mappers.getMapper(DiscussPostDTOConverter.class);

    DiscussPost convertDtoToEntity(DiscussPostDTO discussPostDTO);


    DiscussPostDTO convertEntityToDto(DiscussPost discussPost);
}
