package com.imooc.controller;

import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductInfoService;
import com.imooc.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController  //用此注解不返回页面,配置的视图解析器InternalResourceViewResolver不起作用,返回的内容就是Return 里的内容
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/list")//表示get请求
    public ResultVO list(){
        //1,查询所有上架的商品信息
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        //2,查询类目(一次性查询)
 //      List<Integer> categoryTypeList = new ArrayList<>();
        /*传统方法*/
//        for (ProductInfo productInfo:productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        /*精简方法(java8,lambda)过滤等操作*/
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3,数据拼装(先封装外围类目name,type.foods字段,在封装foods对象)
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            //遍历foods对象ProductInfoVO ,不要将数据库的查询放到for循环中,导致速度变慢
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                   //Spring提供的BeansUtils将productInfo中的数据复制到productInfoVO中
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
//将返回的json对象resultVO进行封装到工具包中
//        ResultVO resultVO = new ResultVO();
//        resultVO.setCode(0);
//        resultVO.setMsg("成功");
//        resultVO.setData(productVOList);

        return ResultVOUtil.success(productVOList);

    }
}
