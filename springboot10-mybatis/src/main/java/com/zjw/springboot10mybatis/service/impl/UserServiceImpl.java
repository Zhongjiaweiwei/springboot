package com.zjw.springboot10mybatis.service.impl;

import com.zjw.springboot10mybatis.dao.UserDao;
import com.zjw.springboot10mybatis.pojo.User;
import com.zjw.springboot10mybatis.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public User selectByName(String name) {
        return userDao.getUserByName(name);
    }
}
