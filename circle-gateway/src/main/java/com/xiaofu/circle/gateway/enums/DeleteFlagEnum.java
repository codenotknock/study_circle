package com.xiaofu.circle.gateway.enums;

/**
 * @author xiaofu
 * @date 2024/1/13 1:02
 * @des
 */
public enum DeleteFlagEnum implements DTEnums{
    DELETE(1, "删除"),
    UN_DELETE(0, "未删除"),
    ;

    private int code;
    private String desc;
    DeleteFlagEnum(int code, String desc) {
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
