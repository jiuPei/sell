package com.imooc.utils;

import com.imooc.enums.CodeEnum;

/**
 * @Author:jiuPei
 * @Date:2018/8/17 22:00
 * @Version 1.0
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
