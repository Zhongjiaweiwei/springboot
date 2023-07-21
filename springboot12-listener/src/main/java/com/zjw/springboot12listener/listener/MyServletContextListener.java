package com.zjw.springboot12listener.listener;

import com.zjw.springboot12listener.pojo.User;
import com.zjw.springboot12listener.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

/**
 * 做缓存
 */
@Component
public class MyServletContextListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //先获取application上下文
        ApplicationContext applicationContext = event.getApplicationContext();
        //获取对应的service
        UserService service = applicationContext.getBean(UserService.class);
        User user = service.getUser();
        //获取application域对象，将查到的东西放在域对象里
        ServletContext servletContext = applicationContext.getBean(ServletContext.class);
        servletContext.setAttribute("user",user);
    }
}
