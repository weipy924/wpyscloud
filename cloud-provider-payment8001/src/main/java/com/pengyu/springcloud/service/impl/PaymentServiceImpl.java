package com.pengyu.springcloud.service.impl;

import com.pengyu.springcloud.dao.PaymentDao;
import com.pengyu.springcloud.entities.Payment;
import com.pengyu.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 支付服务层
 * </p>
 *
 * @author weipengyu
 * @since 2021/3/18-15:57
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(@Param("id") Long id){
        return paymentDao.getPaymentById(id);
    }
}
