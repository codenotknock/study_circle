package com.xiaofu.discuss.server.enums;

/**
 * @author xiaofu
 * @date 2024/1/13 1:02
 * @des
 */
public enum DiscussPostTypeEnum implements DTEnums{
    NOMAL(0, "普通"),
    UN_NOMAL(1, "置顶"),
    ;

    private int code;
    private String desc;
    DiscussPostTypeEnum(int code, String desc) {
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
