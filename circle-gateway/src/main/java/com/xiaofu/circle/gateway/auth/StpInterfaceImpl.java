package com.xiaofu.circle.gateway.auth;

import cn.dev33.satoken.stp.StpInterface;
import com.google.gson.Gson;
import com.xiaofu.circle.gateway.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/16 22:11
 * @des 自定义权限验证接口扩展
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    private RedisUtil redisUtil;

    private String authPermissionPrefix = "auth.premission";

    private String authRolePrefix = "auth.role";

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 返回此用户拥有的权限列表
        // 和数据库交互
        // 存入redis
        // reids 缓存中没有 去auth模块获取


        return getAuth(loginId.toString(), authPermissionPrefix);
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 返回此 loginId 拥有的角色列表

        return getAuth(loginId.toString(), authRolePrefix);
    }

    private List<String> getAuth(String loginId, String prefix) {
        String authKey = redisUtil.buildKey(prefix, loginId.toString());
        String authValue = redisUtil.get(authKey);
        if (StringUtils.isEmpty(authValue)) {
            return Collections.emptyList();
        }
        List authList = new Gson().fromJson(authValue, List.class);
        return authList;
    }

}

