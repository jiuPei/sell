package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * @Author:jiuPei
 * @Date:2018/8/17 22:50
 * @Version 1.0
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);
    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
