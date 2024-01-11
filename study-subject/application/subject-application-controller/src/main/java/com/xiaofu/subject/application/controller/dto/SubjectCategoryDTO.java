package com.xiaofu.subject.application.controller.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author xiaofu
 * @date 2024/1/11 22:41
 * @des
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SubjectCategoryDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String categoryName;

    private Integer categoryType;

    private String imageUrl;

    private Long parentId;

}
