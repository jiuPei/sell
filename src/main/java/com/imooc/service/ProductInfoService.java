package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {
    //根据id查询商品
    ProductInfo findById(String productId);
    //买家查询出所有已经上架商品
    List<ProductInfo> findUpAll();
    //卖家查询出所有商品并且分页展示,返回的是一个page对象
   Page<ProductInfo> findAll(Pageable pageable);
    //新增商品
    ProductInfo save(ProductInfo productInfo);
}
