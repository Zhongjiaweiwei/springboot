package com.zjw.springboot12listener.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * 获取用户的访问信息
 */
@Component
public class MyServletRequestListener implements ServletRequestListener {
    private static final Logger logger= LoggerFactory.getLogger(MyHttpSessionListener.class);

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest servletRequest = (HttpServletRequest) sre.getServletRequest();
        logger.info("session id为：{}", servletRequest.getRequestedSessionId());
        logger.info("request url为：{}", servletRequest.getRequestURL());
        servletRequest.setAttribute("name","钟佳炜");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.info("request end");
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        logger.info("request域中保存的name值为：{}", request.getAttribute("name"));
    }
}
