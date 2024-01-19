package com.xiaofu.common.enums;

import com.xiaofu.common.enums.baseInter.ExceptionEnums;

/**
 * @author xiaofu
 * @date 2024/1/19 20:21
 * @des
 */
public enum BaseErrorCode implements ExceptionEnums {


    /***----------------start 鉴权模块错误码 0 ~ 100 start ------------------****/

    NOT_LOGIN(2, "未登录"),
    PERMISSION_LIMIT(3, "没有权限"),
    TOKEN_IS_NULL(4, "satoken is null"),
    USER_IS_NULL(5, "无此用户"),
    TOKEN_IS_INVALID(6, "satoken is invalid"),


    // ========== 鉴权模块宏观错误码 ==========
    AUTH_ERROR(99, "鉴权模块错误"),
    /***----------------end 鉴权模块错误码 end ------------------****/





    /***----------------start 题目模块错误码 101 ~ 200 start ------------------****/




    // ========== 鉴权模块宏观错误码 ==========
    SUBJECT_ERROR(199, "题目模块错误"),

    /***----------------end 题目模块错误码 end ------------------****/




    /***----------------start 刷题模块错误码 201 ~ 300 start ------------------****/


    // ========== 刷题模块 ==========
    PRACTISE_ERROR(299, "题目模块错误"),

    /***----------------end 刷题模块错误码 end ------------------****/






    /***----------------start 圈子模块错误码 301 ~ 400 start ------------------****/
    /***----------------end 圈子模块错误码 end ------------------****/





    /***----------------start 视频模块错误码 401 ~ 500 start ------------------****/
    /***----------------end 视频模块错误码 end ------------------****/









    ;

    private int code;
    private String desc;
    BaseErrorCode(int code, String desc) {
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