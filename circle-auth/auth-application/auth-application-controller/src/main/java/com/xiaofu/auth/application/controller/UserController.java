package com.xiaofu.auth.application.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.base.Preconditions;
import com.xiaofu.auth.application.convert.AuthUserDTOConverter;
import com.xiaofu.auth.application.dto.AuthUserDTO;
import com.xiaofu.auth.domain.entity.AuthUserBO;
import com.xiaofu.auth.domain.service.AuthUserDomainService;
import com.xiaofu.common.entitiy.Result;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author xiaofu
 * @date 2024/1/15 22:55
 * @des
 */
@RestController
@RequestMapping("/user/")
@Slf4j
public class UserController {
    @Autowired
    private AuthUserDomainService authUserDomainService;


    @ApiOperation(value = "用户注册")
    @PostMapping("register")
    public Result<Boolean> register(@RequestBody AuthUserDTO authUserDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.register.dto:{}", JSON.toJSONString(authUserDTO));
            }
            checkUserInfo(authUserDTO);
            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDtoToBo(authUserDTO);
            return Result.ok(authUserDomainService.register(authUserBO));
        } catch (Exception e) {
            log.error("UserController.register.error:{}", e.getMessage(), e);
            return Result.fail("注册用户失败");
        }
    }


    @ApiOperation(value = "修改用户")
    @PostMapping("update")
    public Result<Boolean> update(@RequestBody AuthUserDTO authUserDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.update.dto:{}", JSON.toJSONString(authUserDTO));
            }
            checkUserInfo(authUserDTO);
            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDtoToBo(authUserDTO);
            return Result.ok(authUserDomainService.update(authUserBO));
        } catch (Exception e) {
            log.error("UserController.update.error:{}", e.getMessage(), e);
            return Result.fail("更新用户信息失败");
        }
    }

    /**
     * 获取用户信息
     */
//    @PostMapping("getUserInfo")
//    public Result<AuthUserDTO> getUserInfo(@RequestBody AuthUserDTO authUserDTO) {
//        try {
//            if (log.isInfoEnabled()) {
//                log.info("UserController.getUserInfo.dto:{}", JSON.toJSONString(authUserDTO));
//            }
//            Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getUserName()), "用户名不能为空");
//            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDTOToBO(authUserDTO);
//            AuthUserBO userInfo = authUserDomainService.getUserInfo(authUserBO);
//            return Result.ok(AuthUserDTOConverter.INSTANCE.convertBOToDTO(userInfo));
//        } catch (Exception e) {
//            log.error("UserController.update.error:{}", e.getMessage(), e);
//            return Result.fail("更新用户信息失败");
//        }
//    }


    @ApiOperation(value = "用户退出")
    @PostMapping("logOut")
    public Result logOut(@RequestParam String userName) {
        try {
            log.info("UserController.logOut.userName:{}", userName);
            Preconditions.checkArgument(!StringUtils.isBlank(userName), "用户名不能为空");
            StpUtil.logout(userName);
            return Result.ok();
        } catch (Exception e) {
            log.error("UserController.logOut.error:{}", e.getMessage(), e);
            return Result.fail("用户登出失败");
        }
    }


    @ApiOperation(value = "删除用户")
    @PostMapping("delete")
    public Result<Boolean> delete(@RequestBody AuthUserDTO authUserDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.delete.dto:{}", JSON.toJSONString(authUserDTO));
            }
            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDtoToBo(authUserDTO);
            return Result.ok(authUserDomainService.delete(authUserBO));
        } catch (Exception e) {
            log.error("UserController.update.error:{}", e.getMessage(), e);
            return Result.fail("删除用户信息失败");
        }
    }

    private void checkUserInfo(@RequestBody AuthUserDTO authUserDTO) {
        Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getUserName()), "用户名不能为空");
    }

    @ApiOperation(value = "用户启用/禁用")
    @PostMapping("changeStatus")
    public Result<Boolean> changeStatus(@RequestBody AuthUserDTO authUserDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.changeStatus.dto:{}", JSON.toJSONString(authUserDTO));
            }
            Preconditions.checkNotNull(authUserDTO.getStatus(), "用户状态不能为空");
            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDtoToBo(authUserDTO);
            return Result.ok(authUserDomainService.update(authUserBO));
        } catch (Exception e) {
            log.error("UserController.changeStatus.error:{}", e.getMessage(), e);
            return Result.fail("启用/禁用用户信息失败");
        }
    }


    // 测试登录，浏览器访问： http://localhost:8081/user/doLogin?username=zhang&password=123456
    @PostMapping("doLogin")
    public Result<SaTokenInfo> doLogin(@RequestParam("validCode") String validCode) {
        try {
            Preconditions.checkArgument(!StringUtils.isBlank(validCode), "验证码不能为空!");
            return Result.ok(authUserDomainService.doLogin(validCode));
        } catch (Exception e) {
            log.error("UserController.doLogin.error:{}", e.getMessage(), e);
            return Result.fail("用户登录失败");
        }
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @PostMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

}
