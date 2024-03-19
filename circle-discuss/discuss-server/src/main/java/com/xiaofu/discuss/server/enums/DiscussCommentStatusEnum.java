package com.xiaofu.discuss.server.enums;

/**
 * @author xiaofu
 * @date 2024/1/13 1:02
 * @des
 */
public enum DiscussCommentStatusEnum implements DTEnums{
    VALID(0, "有效"),
    INVALID(1, "无效"),
    ;

    private int code;
    private String desc;
    DiscussCommentStatusEnum(int code, String desc) {
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
