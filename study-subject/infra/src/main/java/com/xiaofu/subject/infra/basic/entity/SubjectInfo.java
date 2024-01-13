package com.xiaofu.subject.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 题目信息表
 * </p>
 *
 * @author xiaofu
 * @since 2024-01-12
 */
@Data
@Accessors(chain = true)
@TableName("subject_info")
public class SubjectInfo extends BaseEntity {

    /**
     * 题目名称
     */
    @TableField("subject_name")
    private String subjectName;

    /**
     * 题目难度
     */
    @TableField("subject_difficult")
    private Integer subjectDifficult;

    /**
     * 出题人名
     */
    @TableField("settle_name")
    private String settleName;

    /**
     * 题目类型 1单选 2多选 3判断 4简答
     */
    @TableField("subject_type")
    private Integer subjectType;

    /**
     * 题目分数
     */
    @TableField("subject_score")
    private Integer subjectScore;

    /**
     * 题目解析
     */
    @TableField("subject_parse")
    private String subjectParse;



}
