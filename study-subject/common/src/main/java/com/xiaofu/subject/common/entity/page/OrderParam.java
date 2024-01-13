package com.xiaofu.subject.common.entity.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaofu
 * @date 2024/1/13 23:03
 * @des  分页排序字段
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderParam {
    private String field;
    private boolean asc;

}
