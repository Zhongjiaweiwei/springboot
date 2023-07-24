package com.zjw.springboot14redis;

import com.alibaba.fastjson.JSON;
import com.zjw.springboot14redis.pojo.User;
import com.zjw.springboot14redis.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Course14ApplicationTests {
    private static final Logger logger= LoggerFactory.getLogger(Course14ApplicationTests.class);
    @Resource
    private RedisService redisService;

    @Test
    public void contextLoads(){
        //测试redis的string类型
        redisService.setString("张三","一名程序员");
        //如果是实体类型
        User user=new User("李四","深圳福田");
        redisService.setString("user", JSON.toJSONString(user));
    }
}
