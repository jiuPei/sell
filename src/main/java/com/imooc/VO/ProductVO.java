package com.imooc.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.imooc.dataobject.ProductInfo;
import lombok.Data;

import java.util.List;

/**
 * 封装返回json数据data对象中的字段,商品(包含类目)
 */
@Data
public class ProductVO {

    @JsonProperty("name")   //使用次注解,将返回的json字符串中的字段映射成另一个名字
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
