package com.zjw.springboot12listener.service;

import com.zjw.springboot12listener.event.MyEvent;
import com.zjw.springboot12listener.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private ApplicationContext applicationContext;
    public User getUser(){
        return new User("zjw","1234");
    }
    public User getUser2(){
        User user=new User("lmy","123");
        //发布事件
        MyEvent event=new MyEvent(this,user);
        applicationContext.publishEvent(event);
        return user;
    }
}
