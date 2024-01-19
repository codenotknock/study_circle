package com.xiaofu.common.exception;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.xiaofu.common.enums.baseInter.ExceptionEnums;

/**
 * @author xiaofu
 * @date 2024/1/19 21:13
 * @des
 */
public class BaseException extends RuntimeException{
    private String errorMsg;

    private ExceptionEnums errorCode;

    public BaseException(String message){
        super(message);
        setErrorMessage(message);
    }

    public BaseException(ExceptionEnums errorCode){
        super(errorCode.getDesc());
        this.errorCode = errorCode;
        setErrorMessage("");
    }

    public BaseException(String message, ExceptionEnums errorCode){
        super(message);
        this.errorCode = errorCode;
        setErrorMessage(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
        setErrorMessage(message);
    }

    public BaseException(ExceptionEnums errorCode, Throwable cause){
        super(errorCode.getDesc(), cause);
        this.errorCode = errorCode;
        this.errorMsg = errorCode.getDesc();
    }

    public BaseException(String message, ExceptionEnums errorCode, Throwable cause) {
        super(message,cause);
        this.errorCode = errorCode;
        setErrorMessage(message);
    }

    private void setErrorMessage(String errorMessage){
        String errDesc = "";
        if(errorCode == null){
            errDesc = "未定义异常";
        }else{
            errDesc = errorCode.getDesc();
        }

        if(StringUtils.isEmpty(errorMessage)){
            this.errorMsg = errDesc;
        }else{
            this.errorMsg = errorMessage;
        }
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public ExceptionEnums getErrorCode() {
        return errorCode;
    }

}
