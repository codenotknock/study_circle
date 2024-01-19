package com.xiaofu.common.enums;

import com.xiaofu.common.enums.baseInter.BaseEnums;

/**
 * @author xiaofu
 * @date 2024/1/13 1:02
 * @des
 */
public enum DelEnum implements BaseEnums {
    DELETE(1, "删除"),
    UN_DELETE(0, "未删除"),
    ;

    private int code;
    private String desc;
    DelEnum(int code, String desc) {
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
