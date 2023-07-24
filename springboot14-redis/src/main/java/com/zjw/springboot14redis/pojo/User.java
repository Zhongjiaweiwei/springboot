package com.zjw.springboot14redis.pojo;

public class User {
    private String name;
    private String addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public User(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }
}
