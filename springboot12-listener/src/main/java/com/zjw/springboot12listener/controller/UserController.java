package com.zjw.springboot12listener.controller;

import com.zjw.springboot12listener.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/listener")
public class UserController {
    @GetMapping("/user")
    public User getUser(HttpServletRequest request){
        ServletContext servletContext = request.getServletContext();
        return (User) servletContext.getAttribute("user");
    }
}
