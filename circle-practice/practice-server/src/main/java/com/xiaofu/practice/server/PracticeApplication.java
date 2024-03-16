package com.xiaofu.practice.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 刷题微服务启动类
 * @author xiaofu
 * @date 2024/1/10 21:43
 */

@SpringBootApplication
@MapperScan("com.xiaofu.**.mapper")
public class PracticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(PracticeApplication.class, args);
    }
}
