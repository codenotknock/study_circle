package com.xiaofu.auth.common.enums;

/**
 * @author xiaofu
 * @date 2024/1/11 23:00
 * @des
 */
public enum ResultCodeEnum implements DTEnums{
    SUCCESS(200, "执行成功"),
    FAIL(500, "失败"),
    ;

    private int code;
    private String desc;
    ResultCodeEnum(int code, String desc) {
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
