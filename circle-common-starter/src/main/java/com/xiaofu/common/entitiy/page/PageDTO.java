package com.xiaofu.common.entitiy.page;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author xiaofu
 * @date 2024/1/13 22:27
 * @des 分页结果
 */
@Data
@NoArgsConstructor
public class PageDTO <T>{
    private Integer total;

    private Integer pageSize;

    private List<T> result;

    // T --> VO   E --> domain
    public static <T, E> PageDTO<T> transfer(IPage<E> page, Class<T> clazz) {

        PageDTO<T> dto = new PageDTO<>();
        dto.setPageSize((int) page.getPages());
        dto.setTotal((int) page.getTotal());

        List<E> records = page.getRecords();
        if (CollectionUtils.isNotEmpty(records)) {
            // 这里是泛型的转换
            dto.setResult(BeanUtil.copyToList(records, clazz));
        }
        return dto;
    }

    public static <T, E> PageDTO<T> transfer(IPage<E> page, Function<E, T> convertor) {
        /*  T --> VO   E --> domain
        Function 函数式接口编程  convertor 将E对象转换为V对象

        **/
        PageDTO<T> dto = new PageDTO<>();
        dto.setPageSize((int) page.getPages());
        dto.setTotal((int) page.getTotal());

        List<E> records = page.getRecords();
        if (CollectionUtils.isNotEmpty(records)) {
            // 这里是泛型的转换:stream做流的处理并收集结果，convertor 自己进行转换
            List<T> list = records.stream().map(convertor).collect(Collectors.toList());
            dto.setResult(list);
        }
        return dto;
    }
}
