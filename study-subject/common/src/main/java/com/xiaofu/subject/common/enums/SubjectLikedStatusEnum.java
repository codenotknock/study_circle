package com.xiaofu.subject.common.enums;

/**
 * @author xiaofu
 * @date 2024/1/11 23:00
 * @des
 */
public enum SubjectLikedStatusEnum implements DTEnums{
    LIKED(1, "点赞"),
    UN_LIKED(0, "取消点赞"),
    ;

    private int code;
    private String desc;
    SubjectLikedStatusEnum(int code, String desc) {
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
