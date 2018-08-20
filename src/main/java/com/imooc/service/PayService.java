package com.imooc.service;

import com.imooc.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * 支付
 * @Author:jiuPei
 * @Date:2018/8/17 11:06
 * @Version 1.0
 */
public interface PayService {
    PayResponse create(OrderDTO orderDTO);
    PayResponse notify(String notidyData);
    RefundResponse refund(OrderDTO orderDTO);

}
