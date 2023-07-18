package com.zjw.springboot05mvc.controller;

import com.zjw.springboot05mvc.entity.User;
import org.springframework.web.bind.annotation.*;

// @RestController 注解包含了原来的 @Controller 和 @ResponseBody 注解
@RestController
//RequestMapping 是一个用来处理请求地址映射的注解，它可以用于类上，也可以用于方法上。
@RequestMapping("/test")
public class TestController {
    //主要有 GET、PUT、POST、DELETE
    @GetMapping("/test1")
    public String testRequestMapping(){
        return "hello,RequestMapping";
    }
    //路径的id和定义的形参一样
    @RequestMapping("/test2/{id}")
    public String testPathVariable1(Integer id){
        return "hello,PathVariable"+id;
    }
    //路径的id和定义的形参不一样
    @RequestMapping("/test3/{id1}")
    public String testPathVariable2(@PathVariable(value = "id1") Integer id){
        return "hello,PathVariable"+id;
    }

    //@RequestParam 注解顾名思义，也是获取请求参数的
    //@PathValiable 是从 url 模板中获取参数值， 即这种风格的 url：http://localhost:8080/user/{id} ；
    // 而 @RequestParam 是从 request 里面获取参数值，即这种风格的 url：http://localhost:8080/user?id=1
    @RequestMapping("/test4")
    public String testRequestParam1(@RequestParam Integer id){
        return "hello,RequestParam"+id;
    }
    //路径的id和定义的形参不一样
    /*除了 value 属性外，还有个两个属性比较常用：
    required 属性：true 表示该参数必须要传，否则就会报 404 错误，false 表示可有可无。
    defaultValue 属性：默认值，表示如果请求中没有同名参数时的默认值。*/
    @RequestMapping("/test5")
    public String testRequestParam2(@RequestParam("id1") Integer id){
        return "hello,RequestParam"+id;
    }
    //模拟表单提交
    @PostMapping("/test6")
    public String testRequestParam3(@RequestParam("username")String username,@RequestParam("password")String password){
        System.out.println("获取到的信息："+username+","+password);
        return "success";
    }
    //@RequestBody 注解用于接收前端传来的实体，接收参数也是对应的实体
    @RequestMapping("/test7")
    public String testRequestBody(@RequestBody User user){
        System.out.println("接收到的信息："+user.getUsername()+","+user.getPassword());
        return "success";
    }

}
