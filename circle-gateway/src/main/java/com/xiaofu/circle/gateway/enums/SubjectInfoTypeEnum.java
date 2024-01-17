package com.xiaofu.circle.gateway.enums;

/**
 * @author xiaofu
 * @date 2024/1/13 18:15
 * @des
 */
public enum SubjectInfoTypeEnum implements DTEnums{

    RADIO(1, "单选题"),
    MULTIPLE(2, "多选题"),
    JUDGE(3, "判断题"),
    BRIEF(4, "简答题"),
    ;

    private int code;
    private String desc;


    SubjectInfoTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static SubjectInfoTypeEnum getByCode(int code) {
        for (SubjectInfoTypeEnum value : values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
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
