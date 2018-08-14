package com.imooc;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
//@Data
public class LoggerTest {
   // private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    @Test
    public void test1(){
        String name = "imooc";
        String password = "123456";
        log.debug("debug...");
        log.info("name:"+name+"password:"+password);
        log.info("name:{},password:{}",name,password);
        log.error("error..");
    }
}
