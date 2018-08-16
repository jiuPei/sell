package com.imooc.enums;

import lombok.Getter;

/**
 * 商品状态 枚举类型 可直观的查看代码
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"上架"),
    DOWN(1,"下架")
    ;

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
