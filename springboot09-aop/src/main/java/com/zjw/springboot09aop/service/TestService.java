package com.zjw.springboot09aop.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {
    public void say(){
        System.out.println("我就是要执行的方法");
    }
}
