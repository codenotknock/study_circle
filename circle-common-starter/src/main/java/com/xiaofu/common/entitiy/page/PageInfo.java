package com.xiaofu.common.entitiy.page;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaofu
 * @date 2024/1/13 21:55
 * @des 分页请求实体
 */
@Data
public class PageInfo {
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

    public <T> Page<T> toMpPage(OrderItem ... items) {
        Page<T> page = Page.of(pageNo, pageSize);
        if (!orders.isEmpty()) {
            List<OrderItem> orderItemList = orders.stream()
                    .map(orderParam -> new OrderItem(orderParam.getField(), orderParam.isAsc()))
                    .collect(Collectors.toList());
            page.addOrder(orderItemList.toArray(new OrderItem[0]));
        } else if (null != items) {
            page.addOrder(items);
        }
        return page;
    }

}
