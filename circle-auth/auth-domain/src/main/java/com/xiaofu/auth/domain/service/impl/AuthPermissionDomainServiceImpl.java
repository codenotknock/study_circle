package com.xiaofu.auth.domain.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xiaofu.auth.common.constants.AuthConstant;
import com.xiaofu.auth.domain.convert.AuthPermissionBOConverter;
import com.xiaofu.auth.domain.entity.AuthPermissionBO;
import com.xiaofu.auth.domain.redis.RedisUtil;
import com.xiaofu.auth.domain.service.AuthPermissionDomainService;
import com.xiaofu.auth.infra.basic.entity.AuthPermission;
import com.xiaofu.auth.infra.basic.service.AuthPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaofu
 * @date 2024/1/18 0:28
 * @des
 */
@Service
public class AuthPermissionDomainServiceImpl implements AuthPermissionDomainService {
    @Autowired
    private AuthPermissionService authPermissionService;

    @Autowired
    private RedisUtil redisUtil;



    @Override
    public Boolean add(AuthPermissionBO authPermissionBO) {
        AuthPermission authPermission = AuthPermissionBOConverter.INSTANCE.convertBoToEntity(authPermissionBO);
        boolean res = authPermissionService.save(authPermission);
        return res;
    }

    @Override
    public Boolean update(AuthPermissionBO authPermissionBO) {
        AuthPermission authPermission = AuthPermissionBOConverter.INSTANCE.convertBoToEntity(authPermissionBO);
        boolean res = authPermissionService.updateById(authPermission);
        return res;
    }

    @Override
    public Boolean delete(AuthPermissionBO authPermissionBO) {
        boolean res = authPermissionService.removeById(authPermissionBO.getId());
        return res;
    }

    @Override
    public List<String> getPermission(String userName) {
        String permissionKey = redisUtil.buildKey(AuthConstant.authPermissionPrefix, userName);
        String permissionValue = redisUtil.get(permissionKey);
        if (StringUtils.isBlank(permissionValue)) {
            return Collections.emptyList();
        }
        List<AuthPermission> permissionList = new Gson().fromJson(permissionValue,
                new TypeToken<List<AuthPermission>>() {
                }.getType());
        List<String> authList = permissionList.stream().map(AuthPermission::getPermissionKey).collect(Collectors.toList());
        return authList;
    }
}
