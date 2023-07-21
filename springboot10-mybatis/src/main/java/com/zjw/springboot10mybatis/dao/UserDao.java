package com.zjw.springboot10mybatis.dao;

import com.zjw.springboot10mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
User getUserByName(String name);
}
