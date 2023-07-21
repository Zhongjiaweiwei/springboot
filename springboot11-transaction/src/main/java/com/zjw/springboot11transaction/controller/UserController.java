package com.zjw.springboot11transaction.controller;

import com.zjw.springboot11transaction.dao.UserDao;
import com.zjw.springboot11transaction.pojo.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    private UserDao userDao;
    @PostMapping("/user")
    @Transactional
    public String insert(){
        User user = new User("梁朝伟", "123456");
        userDao.insert(user);
        //模拟抛出异常
        int i=10/0;
        return "success";
    }
}
