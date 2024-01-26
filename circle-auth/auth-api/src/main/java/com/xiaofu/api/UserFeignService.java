package com.xiaofu.api;

import com.xiaofu.common.entitiy.Result;
import com.xiaofu.entity.AuthUserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaofu
 * @date 2024/1/27 0:50
 * @des
 */

@FeignClient("circle-auth")
public interface UserFeignService {

    @RequestMapping("/user/getUserInfo")
    Result<AuthUserDTO> getUserInfo(@RequestBody AuthUserDTO authUserDTO);

}
