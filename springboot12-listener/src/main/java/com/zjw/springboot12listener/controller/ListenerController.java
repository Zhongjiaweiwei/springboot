package com.zjw.springboot12listener.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/listener")
public class ListenerController {
    //获取当前在线人数(此方法调不了session销毁)
    @GetMapping("/total")
    public String getTotal(HttpServletRequest request){
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数："+count;
    }
    //改造
    @GetMapping("/total2")
    public String getTotal2(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie;
        try{
            //把sessionId记录在浏览器内
            cookie=new Cookie("JSESSIONID", URLEncoder.encode(request.getSession().getId(),"utf-8"));
            cookie.setPath("/");
            //设置session有效期为2天
            cookie.setMaxAge(48*60*60);//单位为秒
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数："+count;
    }
    @GetMapping("/request")
    public String getRequestInfo(HttpServletRequest request){
        System.out.println("requestListener中的初始化的name数据：" + request.getAttribute("name"));
        return "success";
    }
    @GetMapping("/event")
    public String getEvent(HttpServletRequest request){
        System.out.println("数据："+request.getAttribute("name"));
        return "success";
    }
}
