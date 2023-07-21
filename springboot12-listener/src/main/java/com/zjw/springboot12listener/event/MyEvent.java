package com.zjw.springboot12listener.event;

import com.zjw.springboot12listener.pojo.User;
import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
    private User user;

    public MyEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
