package com.pengyu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>
 * 启动类
 * </p>
 *
 * @author weipengyu
 * @since 2021/3/18-16:51
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderMaim80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMaim80.class, args);
    }
}
