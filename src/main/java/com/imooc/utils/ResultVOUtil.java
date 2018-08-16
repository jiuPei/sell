package com.imooc.utils;

import com.imooc.VO.ResultVO;

/**
 * 相当于JSONUtils.java
 */
public class ResultVOUtil {
    //当返回成功时
    public  static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    //错误
    public static ResultVO error (Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
