package com.zjw.springboot10mybatis.service;

import com.zjw.springboot10mybatis.pojo.User;

public interface UserService {
    User selectByName(String name);
}
