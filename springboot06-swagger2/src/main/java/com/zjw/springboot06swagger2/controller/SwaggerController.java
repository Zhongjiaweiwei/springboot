package com.zjw.springboot06swagger2.controller;

import com.zjw.springboot06swagger2.entity.JsonResult;
import com.zjw.springboot06swagger2.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/swagger")
//@Api 注解用于类上，表示标识这个类是 swagger 的资源。
@Api(value = "Swagger2在线文档")
public class SwaggerController {
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    //@ApiOperation 注解用于方法，表示一个 http 请求的操作。
    @ApiOperation(value = "根据用户唯一标识获取用户信息")
    //@ApiParam 注解用于参数上，用来标明参数信息。
    public JsonResult<User> getUser(@PathVariable @ApiParam(value = "用户唯一标识")Long id){
        //模拟查询
        User user=new User(1L,"zjw","123456");
        System.out.println(id);
        return new JsonResult<>(user);
    }
    @PostMapping("/insert")
    @ApiOperation(value = "添加用户信息")
    public JsonResult<Void> insertUser(@RequestBody @ApiParam(value = "用户信息")User user){
        return new JsonResult<>();
    }
}
