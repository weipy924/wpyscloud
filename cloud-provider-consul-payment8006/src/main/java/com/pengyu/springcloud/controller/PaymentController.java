package com.pengyu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

/**
 * <p>
 * 支付控制层
 * </p>
 *
 * @author weipengyu
 * @since 2021/3/18-16:10
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;


    /**
     * 根据ID查询支付流水单
     * @author weipengyu
     * @date 2021/3/18-16:11
     */
    @GetMapping(value = "/payment/consul")
    public String getPaymentById(){
        return "springCloud with consul : " + serverPort + "  " + UUID.randomUUID().toString();
    }
}
