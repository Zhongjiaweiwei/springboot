package com.zjw.springboot08globalexception.controller;

import com.zjw.springboot08globalexception.exception.BusinessErrorException;
import com.zjw.springboot08globalexception.myEnum.BusinessMsgEnum;
import com.zjw.springboot08globalexception.result.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
    private static final Logger logger= LoggerFactory.getLogger(ExceptionController.class);

    @PostMapping("/exception1")
    public JsonResult test(@RequestParam("name")String name,@RequestParam("password")String password){
        logger.info("name:{}",name);
        logger.info("password:{}",password);
        return new JsonResult();
    }
    @GetMapping("/business")
    public JsonResult testException(){
        try {
            int i=10/0;//模拟出现该异常
        }catch (Exception ex){
            throw new BusinessErrorException(BusinessMsgEnum.UNEXPECTED_EXCEPTION);
        }
        return new JsonResult();
    }
}
