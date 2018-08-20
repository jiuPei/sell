package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.SysexMessage;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;
    @Test
    public void findById()  {
        ProductInfo productInfo = productInfoService.findById("1");
        Assert.assertNotEquals(0,productInfo.getProductId());
        System.out.println(productInfo);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(request);
        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0,productInfoPage.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("2");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductDescription("很好吃的虾婆婆");
        productInfo.setProductIcon("http://***.jsp");
        productInfo.setProductPrice(new BigDecimal(15.3));
        productInfo.setProductStock(100);//库存
        //"0"表示上架,"1"表示下架
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);

        productInfoService.save(productInfo);
    }

    @Test
    public void onSale() {
        ProductInfo result = productInfoService.onSale("1");
        Assert.assertEquals(ProductStatusEnum.UP, result.getProductStatusEnum());
    }

    @Test
    public void offSale() {
        ProductInfo result = productInfoService.offSale("1");
        Assert.assertEquals(ProductStatusEnum.DOWN, result.getProductStatusEnum());
    }

}