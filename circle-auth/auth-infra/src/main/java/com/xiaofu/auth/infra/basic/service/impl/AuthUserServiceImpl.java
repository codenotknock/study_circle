package com.xiaofu.auth.infra.basic.service.impl;

import com.xiaofu.auth.infra.basic.entity.AuthUser;
import com.xiaofu.auth.infra.basic.mapper.AuthUserMapper;
import com.xiaofu.auth.infra.basic.service.AuthUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaofu
 * @since 2024-01-17
 */
@Service
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUser> implements AuthUserService {

}
