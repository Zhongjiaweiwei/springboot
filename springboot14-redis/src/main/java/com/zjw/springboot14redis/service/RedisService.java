package com.zjw.springboot14redis.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class RedisService {
    @Resource
    private StringRedisTemplate redisTemplate;

    public void setString(String key,String value){
        ValueOperations<String,String> valueOperations=redisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    public String getString(String key){
        return redisTemplate.opsForValue().get(key);
    }
}
