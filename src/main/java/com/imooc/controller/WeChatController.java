package com.imooc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:jiuPei
 * @Date:2018/8/18 11:34
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/wechat")
public class WeChatController {

    @RequestMapping("/authorize")
    public void authorize(String returnUrl){
        Wx

    }


}
