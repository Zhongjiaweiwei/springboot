package com.zjw.springboot10mybatis.controller;

import com.zjw.springboot10mybatis.pojo.User;
import com.zjw.springboot10mybatis.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/user/{name}")
    public User getUserByName(@PathVariable("name")String username){
        User user = userService.selectByName(username);
        return user;
    }
}
