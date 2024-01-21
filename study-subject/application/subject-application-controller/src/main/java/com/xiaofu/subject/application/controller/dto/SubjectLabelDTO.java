package com.xiaofu.subject.application.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author xiaofu
 * @date 2024/1/12 22:42
 * @des
 */
@Data
@Accessors(chain = true)

public class SubjectLabelDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String labelName;

    private Integer sortNum;

    private Long categoryId;

}
