package com.pengyu.springcloud.dao;

import com.pengyu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 支付DAO
 * </p>
 *
 * @author weipengyu
 * @since 2021/3/18-15:41
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
