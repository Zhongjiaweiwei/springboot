package com.zjw.springboot13interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorController {

    @RequestMapping("/test")
    public String test(){
        return "index";
    }
}
