package com.xiaofu.discuss.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 帖子讨论服务模块
 * @author xiaofu
 * @date 2024/3/18 16:16
 * @des
 */
@SpringBootApplication
@MapperScan("com.xiaofu.**.mapper")
public class DiscussApplication{
    public static void main( String[] args ) {
        SpringApplication.run(DiscussApplication.class, args);
    }
}
