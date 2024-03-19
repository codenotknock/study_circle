package com.xiaofu.discuss.server.aspect;


import com.xiaofu.api.UserFeignService;
import com.xiaofu.common.entitiy.Result;
import com.xiaofu.discuss.server.context.LoginContextHolder;
import com.xiaofu.discuss.server.context.UserContextHolder;
import com.xiaofu.entity.AuthUserDTO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xiaofu
 * @date 2024/3/18 21:10
 * @des
 */
public class DiscussAspect {

    @Autowired
    private UserFeignService userFeignService;

    @Pointcut(value = "execution(public * com.xiaofu..controller..*.*(..))")
    public void pointCut() {
    }

    @Around(value = "pointCut()")
    public Object before(ProceedingJoinPoint point) throws Throwable {
        AuthUserDTO authUserDTO = new AuthUserDTO();
        authUserDTO.setUserName(LoginContextHolder.getLoginId());
        Result<AuthUserDTO> result = userFeignService.getUserInfo(authUserDTO);

        UserContextHolder.id(result.getData().getId());
        UserContextHolder.userName(result.getData().getUserName());
        UserContextHolder.nickName(result.getData().getNickName());
        UserContextHolder.email(result.getData().getEmail());
        UserContextHolder.phone(result.getData().getPhone());
        UserContextHolder.sex(result.getData().getSex());
        UserContextHolder.avatar(result.getData().getAvatar());
        UserContextHolder.status(result.getData().getStatus());
        UserContextHolder.introduce(result.getData().getIntroduce());
        UserContextHolder.extJson(result.getData().getExtJson());


        return point.proceed();
    }


}
