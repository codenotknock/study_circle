package com.xiaofu.subject.application.controller.dto;

import com.xiaofu.subject.common.entity.page.PageInfo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/13 2:46
 * @des 题目信息
 */
@Data
@Accessors(chain = true)
public class SubjectInfoDTO extends PageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 题目id
     */
    private Long id;


    /**
     * 题目名称
     */
    private String subjectName;

    /**
     * 题目难度
     */
    private Integer subjectDifficult;

    /**
     * 出题人名
     */
    private String settleName;

    /**
     * 题目类型 1单选 2多选 3判断 4简答
     */
    private Integer subjectType;

    /**
     * 题目分数
     */
    private Integer subjectScore;

    /**
     * 题目解析
     */
    private String subjectParse;

    /**
     * 分类id
     */
    private List<Long> categoryIds;

    /**
     * 标签id
     */
    private List<Long> labelIds;

    /**
     * 答案选项内容
     */
    private List<SubjectAnswerDTO> optionList;


    /**
     * 题目答案
     */
    private String subjectAnswer;


    /**
     * 查询题目列表
     */
    private Long categoryId;
    private Long labelId;


}
