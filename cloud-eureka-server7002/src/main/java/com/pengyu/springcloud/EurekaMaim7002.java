package com.pengyu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>
 * 启动类
 * </p>
 *
 * @author weipengyu
 * @since 2021/3/22-17:00
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMaim7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMaim7002.class, args);
    }
}
