package com.xiaofu.common.enums;

import com.xiaofu.common.enums.baseInter.BaseEnums;

/**
 * @author xiaofu
 * @date 2024/1/19 21:03
 * @des
 */
public enum FlagEnum implements BaseEnums {

    FALSE(0, "false"),

    TRUE(1, "true");
    ;

    private int code;
    private String desc;
    FlagEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}