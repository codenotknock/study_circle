package com.xiaofu.subject.infra.basic.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * @author xiaofu
 * @date 2024/1/12 21:18
 * @des 题目标签表
 */
@Data
@Accessors(chain = true)
@TableName("subject_label")
public class SubjectLabel extends BaseEntity{

    private String labelName;

    private Integer sortNum;

    private Long categoryId;

}