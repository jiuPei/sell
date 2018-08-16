package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveProductInfo(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1");
        productInfo.setProductName("皮蛋瘦肉粥");
        productInfo.setProductDescription("新鲜味美");
        productInfo.setProductIcon("http://***.jsp");
        productInfo.setProductPrice(new BigDecimal(2.5));
        productInfo.setProductStock(100);//库存
        //"0"表示上架,"1"表示下架
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByProductStatus() {
        //查询上架的商品
        List<ProductInfo> productInfoList = repository.findByProductStatus(0);
        //只要集合的长度不为0即可
        Assert.assertNotEquals(0,productInfoList.size());
    }
}