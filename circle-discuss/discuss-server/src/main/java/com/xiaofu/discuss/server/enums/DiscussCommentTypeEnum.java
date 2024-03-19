package com.xiaofu.discuss.server.enums;

/**
 * @author xiaofu
 * @date 2024/1/13 1:02
 * @des
 */
public enum DiscussCommentTypeEnum implements DTEnums{
    COMMENTS(0, "评论"),
    REPLY(1, "回复"),
    ;

    private int code;
    private String desc;
    DiscussCommentTypeEnum(int code, String desc) {
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
