package com.xiaofu.discuss.server.convert;

import com.xiaofu.discuss.server.dao.entity.DiscussMessage;
import com.xiaofu.discuss.server.dto.DiscussMessageDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xiaofu
 * @date 2024/3/18 15:31
 * @des
 */
@Mapper
public interface DiscussMessageDTOConverter {
    DiscussMessageDTOConverter INSTANCE =  Mappers.getMapper(DiscussMessageDTOConverter.class);

    DiscussMessage convertDtoToEntity(DiscussMessageDTO discussMessageDTO);

    List<DiscussMessage> convertDtoToEntityList(List<DiscussMessageDTO> discussMessageDTOList);


    DiscussMessageDTO convertEntityToDto(DiscussMessage discussMessage);

    List<DiscussMessageDTO> convertEntityToDtoList(List<DiscussMessage> discussMessageList);
}
