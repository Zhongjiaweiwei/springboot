package com.zjw.springboot02json.controller;

import com.zjw.springboot02json.entity.JsonResult;
import com.zjw.springboot02json.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/json")
public class JsonController {
    //user单体
    @RequestMapping("/user")
    /*public User getUser(){
        return new User(1L,"zhangsan","123456");
    }*/
    public JsonResult<User> getUser(){
        User user=new User(1L,"zhangsan","123456");
        return new JsonResult<>(user);
    }
    //user的List集合
    /*@RequestMapping("/list")
    public List<User> getList(){
        List<User> list=new ArrayList<>();
        User user1=new User(2L,"lisi","123456");
        User user2=new User(3L,"wangwu","123456");
        list.add(user1);
        list.add(user2);
        return list;
    }*/
    @RequestMapping("/list")
    public JsonResult<List> getList(){
        List<User> list=new ArrayList<>();
        User user1=new User(2L,"lisi","123456");
        User user2=new User(3L,"wangwu","123456");
        list.add(user1);
        list.add(user2);
        return new JsonResult<>(list,"获取用户列表成功");
    }
    //user的Map集合
    @RequestMapping("/map")
    /*public Map<String,Object> getMap(){
        Map<String,Object> map=new HashMap<>();
        User user=new User(4L,"zhaoliu","123456");
        map.put("作者信息",user);
        map.put("作者籍贯","广东汕尾");
        map.put("粉丝数量",null);
        return map;
    }*/
    public JsonResult<Map> getMap(){
        Map<String,Object> map=new HashMap<>();
        User user=new User(4L,"zhaoliu","123456");
        map.put("作者信息",user);
        map.put("作者籍贯","广东汕尾");
        map.put("粉丝数量",null);
        return new JsonResult<>(map);
    }
}
