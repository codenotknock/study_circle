package com.xiaofu.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xiaofu
 * @date 2024/1/14 19:54
 * @des
 */
@SpringBootApplication
@ComponentScan("com.xiaofu")
public class OssApplication {
    public static void main( String[] args )
    {
        SpringApplication.run(OssApplication.class, args);
    }
}
