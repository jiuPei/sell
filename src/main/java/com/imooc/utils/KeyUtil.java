package com.imooc.utils;

import java.util.Random;

/**
 * 生成唯一主键
 * 用时间+随机数实现
 */
public class KeyUtil {
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer n = random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(n);
    }

}
