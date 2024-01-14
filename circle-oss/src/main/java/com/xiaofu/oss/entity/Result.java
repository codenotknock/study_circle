package com.xiaofu.oss.entity;

import com.xiaofu.oss.entity.enums.ResultCodeEnum;
import lombok.Data;

/**
 * @author xiaofu
 * @date 2024/1/11 22:52
 * @des
 */
@Data
public class Result<T>{

    /**
     * 是否成功
     */
    public Boolean success;

    /**
     * 状态码
     */
    public int code;

    /**
     * 异常信息
     */
    public String message;

    /**
     * 返回值
     */
    private T data;

    /**
     * 请求时间
     */
    private long space;

    public final static Result ok() {
        return new Result()
                .success(Boolean.TRUE)
                .code(ResultCodeEnum.SUCCESS.code())
                .message(ResultCodeEnum.SUCCESS.desc());
    }
    public final static <T> Result<T> ok(T data) {
        return new Result()
                .success(Boolean.TRUE)
                .code(ResultCodeEnum.SUCCESS.code())
                .data(data);
    }

    public final static Result fail() {
        return new Result()
                .success(Boolean.TRUE)
                .code(ResultCodeEnum.FAIL.code())
                .message(ResultCodeEnum.FAIL.desc());
    }
    public final static <T> Result<T> fail(String message) {
        return new Result()
                .success(Boolean.FALSE)
                .code(ResultCodeEnum.FAIL.code())
                .message(message);
    }
    public final static <T> Result<T> fail(int code, String message) {
        return new Result()
                .success(Boolean.FALSE)
                .code(code)
                .message(message);
    }


    public Result<T> success(Boolean success) {
        this.success = success;
        return this;
    }

    public Result<T> data(T data) {
        this.data = data;
        return this;
    }

    public Result<T> code(int code) {
        this.code = code;
        return this;
    }

    public Result<T> message(String message) {
        this.message = message;
        return this;
    }

    public Result<T> space(long space) {
        this.space = space;
        return this;
    }

    /**
     * 是否成功标志位,便于前端进行返回判断
     * @return
     */
    public boolean isSuccess() {
        return getCode() == ResultCodeEnum.SUCCESS.getCode();
    }

}