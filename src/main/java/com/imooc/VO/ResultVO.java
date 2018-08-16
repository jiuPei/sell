package com.imooc.VO;

import lombok.Data;

/**
 * VO返回给前端的对象
 * HTTP请求返回最外层的对象
 */
@Data//次注解可代替get和set方法
public class ResultVO <T>{
    //code表示状态码
    private Integer code;
    //msg表示返回的提示信息
    private String msg;
    //返回的具体内容
    private T data;

}
