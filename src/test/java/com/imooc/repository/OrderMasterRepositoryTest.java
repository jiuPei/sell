package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    private final  String OPENID="110110";
    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("3");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("123456789123");
        orderMaster.setBuyerAddress("上海市");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(3.8));

        OrderMaster result=repository.save(orderMaster);
        Assert.assertNotNull(result);//结果不为空,就可以通过
    }
    @Test
    public void findBYBuyerOpenid() {
        PageRequest request = new PageRequest(0,2);
        Page<OrderMaster> page = repository.findByBuyerOpenid(OPENID,request);
         System.out.println(page.getTotalElements());
         Assert.assertNotEquals(0,page.getTotalElements());

    }
}