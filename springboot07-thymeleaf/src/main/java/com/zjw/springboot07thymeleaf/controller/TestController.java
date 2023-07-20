package com.zjw.springboot07thymeleaf.controller;

import com.zjw.springboot07thymeleaf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    @RequestMapping("/test1")
    public String test(){
        return "index";
    }
    @RequestMapping("/test2")
    public String test500(){
        int i=10/0;
        return "index";
    }
    // thymeleaf 模板中如何处理对象信息
    @RequestMapping("/test3")
    public String getUser(Model model){
        User user=new User(1L,"zhang","123456");
        model.addAttribute("user",user);
        return "list";
    }
    //处理list
    @RequestMapping("/test4")
    public String getList(Model model){
        User user1=new User(1L,"zjw","123456");
        User user2=new User(2L,"lmy","123456");
        List<User> list=new ArrayList<>();
        list.add(user1);
        list.add(user2);
        model.addAttribute("list",list);
        return "userList";
    }
}
