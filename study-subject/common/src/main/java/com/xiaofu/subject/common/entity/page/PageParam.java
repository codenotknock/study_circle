package com.xiaofu.subject.common.entity.page;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/13 21:55
 * @des 分页请求实体
 */
public class PageParam {
    private String search;

    /**
     * 当前页
     */
    private Integer pageNo = 1;

    /**
     * 每页大小
     */
    private Integer pageSize = 20;

    /**
     * 排序字段
     */
    private List<OrderParam> orders = new LinkedList();

    public Integer getPageNo() {
        if (pageNo == null || pageNo < 1) {
            return 1;
        }
        return pageNo;
    }

    public Integer getPageSize() {
        if (null == pageSize || pageSize < 1 || pageSize > Integer.MAX_VALUE) {
            return 20;
        }
        return pageSize;
    }



}
