package com.xiaofu.circle.gateway.exception;

import com.xiaofu.common.entitiy.Result;
import com.xiaofu.common.exception.BaseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiaofu
 * @date 2024/1/16 23:53
 * @des  网关全局异常处理
 */
//public class GatewayExceptionHandler implements ErrorWebExceptionHandler {
//    private ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {
//        ServerHttpRequest request = serverWebExchange.getRequest();
//        ServerHttpResponse response = serverWebExchange.getResponse();
//        Integer code = 200;
//        String message = "";
//        if (throwable instanceof SaTokenException) {
//            code = 401;
//            message = "用户无权限";
//        } else {
//            code = 500;
//            message = "系统繁忙";
//        }
//        Result result = Result.fail(code, message);
//        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
//        return response.writeWith(Mono.fromSupplier(() -> {
//            DataBufferFactory dataBufferFactory = response.bufferFactory();
//            byte[] bytes = null;
//            try {
//                bytes = objectMapper.writeValueAsBytes(result);
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//            return dataBufferFactory.wrap(bytes);
//        }));
//    }
//}
@ControllerAdvice
public class GlobalException {

    // 全局异常拦截（拦截项目中的所有异常）
    @ResponseBody
    @ExceptionHandler
    public Result handlerException(Exception e) {

        // 打印堆栈，以供调试
//        System.out.println("全局异常---------------");
        e.printStackTrace();
        // 不同异常返回不同状态码
//        AjaxJson aj = null;
//        if (e instanceof NotLoginException) {	// 如果是未登录异常
//            NotLoginException ee = (NotLoginException) e;
//            aj = AjaxJson.getNotLogin().setMsg(ee.getMessage());
//        }
//        else if(e instanceof NotRoleException) {		// 如果是角色异常
//            NotRoleException ee = (NotRoleException) e;
//            aj = AjaxJson.getNotJur("无此角色：" + ee.getRole());
//        }
//        else if(e instanceof NotPermissionException) {	// 如果是权限异常
//            NotPermissionException ee = (NotPermissionException) e;
//            aj = AjaxJson.getNotJur("无此权限：" + ee.getCode());
//        }
//        else if(e instanceof DisableLoginException) {	// 如果是被封禁异常
//            DisableLoginException ee = (DisableLoginException) e;
//            aj = AjaxJson.getNotJur("账号被封禁：" + ee.getDisableTime() + "秒后解封");
//        }
//        else {	// 普通异常, 输出：500 + 异常信息
//            aj = AjaxJson.getError(e.getMessage());
//        }
        if (e instanceof BaseException) {
            return Result.fail(((BaseException) e).getErrorCode().getCode(), e.getMessage());
        }

        // 返回给前端
        return Result.fail(e.getMessage());
    }

}