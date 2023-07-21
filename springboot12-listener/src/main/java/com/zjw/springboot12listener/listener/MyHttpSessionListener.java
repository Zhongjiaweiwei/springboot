package com.zjw.springboot12listener.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 获取在线人数
 */
@Component
public class MyHttpSessionListener implements HttpSessionListener {
    private static final Logger logger= LoggerFactory.getLogger(MyHttpSessionListener.class);
    //记录在线的用户数量
    public Integer count=0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info("用户上线了");
        count++;
        se.getSession().getServletContext().setAttribute("count",count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("用户下线了");
        count--;
        se.getSession().getServletContext().setAttribute("count",count);
    }
}
