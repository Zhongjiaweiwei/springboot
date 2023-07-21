package com.zjw.springboot11transaction.dao;

import com.zjw.springboot11transaction.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    void insert(User user);
}
