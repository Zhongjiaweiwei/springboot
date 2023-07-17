package com.zjw.springboot01start.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/start")
public class MainController {
    @RequestMapping("/hello")
    public String sayHello(){
        return "hello,springboot";
    }
}
