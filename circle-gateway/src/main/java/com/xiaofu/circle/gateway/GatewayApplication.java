package com.xiaofu.circle.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xiaofu
 * @date 2024/1/16 20:27
 * @des
 */
@SpringBootApplication
@ComponentScan("com.xiaofu")
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
