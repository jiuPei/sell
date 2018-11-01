package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author:jiuPei
 * @Date:2018/8/20 13:36
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {
    @Autowired
    private PayServiceImpl payService;
    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = orderService.findOne("2");
        payService.create(orderDTO);
    }


    @Test
    public void refund() {
        OrderDTO orderDTO = orderService.findOne("2");
        payService.refund(orderDTO);
    }

    
    //  @Test
    // public void refund() {
    //     OrderDTO orderDTO = orderService.findOne("2");
    //     payService.refund(orderDTO);
    // }
}