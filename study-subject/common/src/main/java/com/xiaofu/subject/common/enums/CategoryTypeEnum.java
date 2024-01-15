package com.xiaofu.subject.common.enums;

/**
 * @author xiaofu
 * @date 2024/1/13 18:15
 * @des
 */
public enum CategoryTypeEnum implements DTEnums{

    PRIMARY(1,"一级大类"),
    SECOND(2,"二级分类"),
    ;

    private int code;
    private String desc;


    CategoryTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static CategoryTypeEnum getByCode(int code) {
        for (CategoryTypeEnum value : values()) {
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
