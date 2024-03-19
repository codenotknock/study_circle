package com.xiaofu.discuss.server.dao.mapper;

import com.xiaofu.discuss.server.dao.entity.DiscussMessage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 * 消息表 Mapper 接口
 * </p>
 *
 * @author xiaofu
 * @since 2024-03-18
 */
public interface DiscussMessageMapper extends BaseMapper<DiscussMessage> {


    @Select("select * from message where id in (select max(id) from message " +
            "where status!=2 and from_id !=1 and (from_id =#{userId} or to_id =#{userId}) group by conversation_id)  " +
            "order by id desc limit #{offset},#{size} ")
    List<DiscussMessage> getConversations(Long userId, int offset, int size);

    @Select("select  count(distinct conversation_id) from message " +
            "where status!=2 and from_id !=1 and (from_id =#{userId} or to_id =#{userId})")
    int getConversationCount(Long userId);

    @Select("select * from message" +
            " where conversation_id =#{conversationId} and status!=2")
    List<DiscussMessage> selectLetters(String conversationId);

    @Select("select count(id) from message where conversation_id=#{conversationId}")
    int selectLetterCount(String conversationId);

    @Select("select count(id) from message where conversation_id=#{conversationId} and status=0")
    int selectUnread(String conversationId);

    @Select("select count(id) from message where to_id =#{userId} and from_id !=1  and status=0")
    int selectTotalUnread(Long userId);

}
