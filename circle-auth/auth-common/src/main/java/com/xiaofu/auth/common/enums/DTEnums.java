package com.xiaofu.auth.common.enums;

/**
 * @author xiaofu
 * @date 2024/1/11 22:56
 * @des
 */
public interface DTEnums {
    int getCode();
    String getDesc();
    default int code() {
        return getCode();
    }

    default String desc() {
        return getDesc();
    }
}
