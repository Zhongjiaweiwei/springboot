package com.zjw.springboot09aop.controller;

import com.zjw.springboot09aop.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    private TestService testService;

    @RequestMapping("/test")
    public String test(){
        testService.say();
        return "success";
    }
}
