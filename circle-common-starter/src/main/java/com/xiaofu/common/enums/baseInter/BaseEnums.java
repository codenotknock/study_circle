package com.xiaofu.common.enums.baseInter;

/**
 * @author xiaofu
 * @date 2024/1/19 14:45
 * @des
 */
public interface BaseEnums {
    int getCode();

    String getDesc();

    default int code() {
        return getCode();
    }

    default String desc() {
        return getDesc();
    }
}
