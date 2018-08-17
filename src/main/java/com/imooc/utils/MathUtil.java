package com.imooc.utils;

/**
 * @Author:jiuPei
 * @Date:2018/8/17 13:46
 * @Version 1.0
 */
public class MathUtil {

    private  static final Double MONEY_RANGE = 0.01;
    /**
     * 比较两个金额是否相等
     */
    public static boolean equals(Double d1,Double d2){
        Double result = Math.abs(d1-d2);
        if (result<MONEY_RANGE){
            return true;
        }else {
            return false;
        }

    }
}
