package com.imooc.controller;

import com.imooc.dataobject.ProductInfo;
import com.imooc.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 卖家端商品
 * @Author:jiuPei
 * @Date:2018/8/20 21:16
 * @Version 1.0
 */
@Controller
@RequestMapping("/seller/product")
public class SellProductController {
    @Autowired
    private ProductInfoService productInfoService;

    /**
     * 商品列表
     */
    @RequestMapping("list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "5") Integer size,
                             Map<String,Object>map){

        PageRequest request = new PageRequest(page-1,size);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(request);
        map.put("productInfoPage",productInfoPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("product/list",map);
    }
}
