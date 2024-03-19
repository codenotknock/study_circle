package com.xiaofu.discuss.server.enums;

/**
 * @author xiaofu
 * @date 2024/1/13 1:02
 * @des
 */
public enum DiscussMessageStatusEnum implements DTEnums{
    UN_READ(0, "未读"),
    READ(1, "已读"),
    DELETE(2, "删除"),
    ;
    private int code;
    private String desc;
    DiscussMessageStatusEnum(int code, String desc) {
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
