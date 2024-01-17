package com.xiaofu.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.gson.Gson;
import com.xiaofu.auth.common.enums.AuthUserStatusEnum;
import com.xiaofu.auth.domain.constants.AuthConstant;
import com.xiaofu.auth.domain.convert.AuthUserBOConverter;
import com.xiaofu.auth.domain.entity.AuthUserBO;
import com.xiaofu.auth.domain.redis.RedisUtil;
import com.xiaofu.auth.domain.service.AuthUserDomainService;
import com.xiaofu.auth.infra.basic.entity.AuthPermission;
import com.xiaofu.auth.infra.basic.entity.AuthRole;
import com.xiaofu.auth.infra.basic.entity.AuthRolePermission;
import com.xiaofu.auth.infra.basic.entity.AuthUser;
import com.xiaofu.auth.infra.basic.entity.AuthUserRole;
import com.xiaofu.auth.infra.basic.service.AuthPermissionService;
import com.xiaofu.auth.infra.basic.service.AuthRolePermissionService;
import com.xiaofu.auth.infra.basic.service.AuthRoleService;
import com.xiaofu.auth.infra.basic.service.AuthUserRoleService;
import com.xiaofu.auth.infra.basic.service.AuthUserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaofu
 * @date 2024/1/17 20:56
 * @des
 */
@Service
public class AuthUserDomainServiceIml implements AuthUserDomainService {

    @Autowired
    private AuthUserService authUserService;

    @Autowired
    private AuthUserRoleService authUserRoleService;

    @Autowired
    private AuthPermissionService authPermissionService;

    @Autowired
    private AuthRolePermissionService authRolePermissionService;

    @Autowired
    private AuthRoleService authRoleService;

    private String salt = "xiaofu";

    @Resource
    private RedisUtil redisUtil;

    private String authPermissionPrefix = "auth.permission";

    private String authRolePrefix = "auth.role";

    private static final String LOGIN_PREFIX = "loginCode";

    @Override
    @SneakyThrows
    @Transactional(rollbackFor = Exception.class)
    public Boolean register(AuthUserBO authUserBO) {
        //校验用户是否存在
        Long count = authUserService.lambdaQuery().eq(AuthUser::getUserName, authUserBO.getUserName()).count();
        if (count> 0) {
            return true;
        }
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBoToEntity(authUserBO);
        if (StringUtils.isNotBlank(authUser.getPassword())) {
            authUser.setPassword(SaSecureUtil.md5BySalt(authUser.getPassword(), salt));
        }
        if (StringUtils.isBlank(authUser.getAvatar())) {
            authUser.setAvatar("http://47.113.198.8:9090/browser/test/avt%20(10).png");
        }
        authUser.setStatus(AuthUserStatusEnum.OPEN.getCode());
        boolean res = authUserService.save(authUser);


        AuthRole roleResult = authRoleService.lambdaQuery().eq(AuthRole::getRoleKey, AuthConstant.NORMAL_USER).one();
        //建立一个初步的角色的关联
        AuthRole authRole = new AuthRole();
        authRole.setRoleKey(AuthConstant.NORMAL_USER);
        Long roleId = roleResult.getId();
        Long userId = authUser.getId();
        AuthUserRole authUserRole = new AuthUserRole();
        authUserRole.setUserId(userId);
        authUserRole.setRoleId(roleId);
        authUserRoleService.save(authUserRole);

        String roleKey = redisUtil.buildKey(authRolePrefix, authUser.getUserName());
        List<AuthRole> roleList = new LinkedList<>();
        roleList.add(authRole);
        redisUtil.set(roleKey, new Gson().toJson(roleList));
        //根据roleId查权限
        List<AuthRolePermission> rolePermissionList = authRolePermissionService.lambdaQuery()
                .eq(AuthRolePermission::getRoleId, roleId).list();
        List<Long> permissionIdList = rolePermissionList.stream()
                .map(AuthRolePermission::getPermissionId).collect(Collectors.toList());
        List<AuthPermission> permissionList = authPermissionService.listByIds(permissionIdList);
        String permissionKey = redisUtil.buildKey(authPermissionPrefix, authUser.getUserName());
        redisUtil.set(permissionKey, new Gson().toJson(permissionList));

        return res;
    }

    @Override
    public Boolean update(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBoToEntity(authUserBO);
        boolean res = authUserService.updateById(authUser);
        return res;
    }

    @Override
    public Boolean delete(AuthUserBO authUserBO) {
        AuthUser authUser = new AuthUser();
        authUser.setId(authUserBO.getId());
        boolean res = authUserService.removeById(authUser);
        //有任何的更新，都要与缓存进行同步的修改
        return res;
    }

    @Override
    public SaTokenInfo doLogin(String validCode) {
        String loginKey = redisUtil.buildKey(LOGIN_PREFIX, validCode);
        String openId = redisUtil.get(loginKey);
        if (StringUtils.isBlank(openId)) {
            return null;
        }
        AuthUserBO authUserBO = new AuthUserBO();
        authUserBO.setUserName(openId);
        this.register(authUserBO);
        StpUtil.login(openId);
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return tokenInfo;
    }

    @Override
    public AuthUserBO getUserInfo(AuthUserBO authUserBO) {
        List<AuthUser> userList = authUserService.lambdaQuery().eq(AuthUser::getUserName, authUserBO.getUserName()).list();
        if(CollectionUtils.isEmpty(userList)){
            return new AuthUserBO();
        }
        AuthUser user = userList.get(0);
        return AuthUserBOConverter.INSTANCE.convertEntityToBo(user);
    }
}
