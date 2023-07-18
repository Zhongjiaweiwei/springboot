package com.zjw.springboot04attribute.controller;

import com.zjw.springboot04attribute.url.MicroServiceUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/test")
public class ConfigController {
    private static final Logger LOGGER= LoggerFactory.getLogger(ConfigController.class);

    @Value("${url.orderUrl}")
    private String orderUrl;

    @Resource
    private MicroServiceUrl serviceUrl;

    @RequestMapping("/config")
    public String testConfig(){
        LOGGER.info("------------获取的订单服务地址为：{}",orderUrl);
        return "success";
    }

    @RequestMapping("/serviceUrl")
    public String testService(){
        return  serviceUrl.getUserUrl()+serviceUrl.getShoppingUrl();
    }
}
