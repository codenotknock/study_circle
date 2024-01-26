package com.xiaofu.auth.infra.basic.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.xiaofu.auth.common.util.LoginUtil;
import com.xiaofu.auth.infra.basic.config.interceptor.MybatisPlusSqlLogInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;

/**
 * @author xiaofu
 * @date 2024/1/13 0:31
 * @des mp 配置
 */

@Slf4j
@Configuration
public class MyBatisPlusConf {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        // 分页插件
        // 初始化核心插件
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加分页插件
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        // 设置分页上限为999
        paginationInnerInterceptor.setMaxLimit(999L);
        interceptor.addInnerInterceptor(paginationInnerInterceptor);

        // sql日志信息
        interceptor.addInnerInterceptor(new MybatisPlusSqlLogInterceptor());

        return interceptor;
    }

    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new MetaObjectHandler() {
            @Override
            public void insertFill(MetaObject metaObject) {
                log.info("start insert fill ....");
                this.strictInsertFill(metaObject, "createdTime", Timestamp.class, new Timestamp(System.currentTimeMillis()));
                this.strictInsertFill(metaObject, "updateTime", Timestamp.class, new Timestamp(System.currentTimeMillis()));
                this.strictInsertFill(metaObject, "createdBy", String.class, LoginUtil.getLoginId());
                this.strictInsertFill(metaObject, "updateBy", String.class, LoginUtil.getLoginId());
                this.strictInsertFill(metaObject, "isDeleted", Integer.class, 0);
            }

            @Override
            public void updateFill(MetaObject metaObject) {
                log.info("start update fill ....");
                this.strictInsertFill(metaObject, "updateBy", String.class, LoginUtil.getLoginId());
                this.strictUpdateFill(metaObject, "updateTime", Timestamp.class, new Timestamp(System.currentTimeMillis()));
            }
        };
    }


}
