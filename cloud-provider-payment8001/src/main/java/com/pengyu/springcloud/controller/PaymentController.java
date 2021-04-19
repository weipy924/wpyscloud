package com.pengyu.springcloud.controller;

import com.pengyu.springcloud.entities.CommonResult;
import com.pengyu.springcloud.entities.Payment;
import com.pengyu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 插入支付流水单
     * @author weipengyu
     * @date 2021/3/18-16:10
     */
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if (result > 0){
            log.info("create success, result:{}", result);
            return new CommonResult(200 ,"create success,serverPort :" + serverPort, result);
        }else {
            log.info("create failed, result:{}", result);
            return new CommonResult(444 ,"create failed", null);
        }
    }

    /**
     * 根据ID查询支付流水单
     * @author weipengyu
     * @date 2021/3/18-16:11
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (null != payment){
            log.info("getPaymentById success, result:{}", payment);
            return new CommonResult(200 ,"getPaymentById ,serverPort :" + serverPort, payment);
        }else {
            log.info("getPaymentById success, result:{}", payment);
            return new CommonResult(444 ,"getPaymentById failed", null);
        }
    }

    /**
     * 获取服务信息
     * @author weipengyu
     * @date 2021/3/18-16:11
     */
    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:{}", service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("instance.host:{},instance.port:{},instance.uri:{},", instance.getHost(), instance.getPort(), instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
