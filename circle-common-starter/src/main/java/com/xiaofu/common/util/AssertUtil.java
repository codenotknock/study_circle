package com.xiaofu.common.util;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.xiaofu.common.enums.baseInter.ExceptionEnums;
import com.xiaofu.common.exception.BaseException;

import java.util.Collection;
import java.util.Objects;

/**
 * @author xiaofu
 * @date 2024/1/19 22:04
 * @des 工具类
 */
public abstract class AssertUtil {


    /**
     * 不是true 抛出异常
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new BaseException(message);
        }
    }
    public static void isTrue(boolean expression, ExceptionEnums errorCode) {
        if (!expression) {
            throw new BaseException(errorCode);
        }
    }
    public static void isTrue(boolean expression, String message, ExceptionEnums errorCode) {
        if (!expression) {
            throw new BaseException(message, errorCode);
        }
    }


    /**
     * 不是false 抛出异常
     */

    public static void isFalse(boolean expression, String message) {
        if (expression) {
            throw new BaseException(message);
        }
    }
    public static void isFalse(boolean expression, ExceptionEnums errorCode) {
        if (expression) {
            throw new BaseException(errorCode);
        }
    }
    public static void isFalse(boolean expression, String message, ExceptionEnums errorCode) {
        if (expression) {
            throw new BaseException(message, errorCode);
        }
    }


    /**
     * null 抛出异常
     */
    public static void isNotNull(Object object, String message) {
        if (Objects.isNull(object)) {
            throw new BaseException(message);
        }
    }
    public static void isNotNull(Object object, ExceptionEnums errorCode) {
        if (Objects.isNull(object)) {
            throw new BaseException(errorCode);
        }
    }
    public static void isNotNull(Object object, String message, ExceptionEnums errorCode) {
        if (Objects.isNull(object)) {
            throw new BaseException(message, errorCode);
        }
    }
    public static void isNotNull(Collection collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new BaseException(message);
        }
    }
    public static void isNotNull(Collection collection, ExceptionEnums errorCode) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new BaseException(errorCode);
        }
    }
    public static void isNotNull(Collection collection, String message, ExceptionEnums errorCode) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new BaseException(message, errorCode);
        }
    }


    /**
     * 字符串为null或空白 抛出异常
     */
    public static void isNotBlank(String str, String message) {
        if (null == str || StringUtils.isBlank(str)) {
            throw new BaseException(message);
        }
    }
    public static void isNotBlank(String str, ExceptionEnums errorCode) {
        if (null == str || StringUtils.isBlank(str)) {
            throw new BaseException(errorCode);
        }
    }
    public static void isNotBlank(String str, String message, ExceptionEnums errorCode) {
        if (null == str || StringUtils.isBlank(str)) {
            throw new BaseException(message, errorCode);
        }
    }




}
