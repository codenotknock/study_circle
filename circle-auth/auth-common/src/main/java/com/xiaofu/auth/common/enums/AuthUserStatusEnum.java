package com.xiaofu.auth.common.enums;

/**
 * @author xiaofu
 * @date 2024/1/17 21:16
 * @des
 */
public enum AuthUserStatusEnum implements DTEnums {

    OPEN(0,"启用"),
    CLOSE(1,"禁用");

    public int code;

    public String desc;

    AuthUserStatusEnum(int code, String desc){
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