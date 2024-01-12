package com.xiaofu.subject.domain.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.xiaofu.subject.infra.basic.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * @author xiaofu
 * @date 2024/1/12 21:18
 * @des 题目标签表
 */
@Data
@Accessors(chain = true)
public class SubjectLabelBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String labelName;

    private Integer sortNum;

    private Long categoryId;

}