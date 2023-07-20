package com.zjw.springboot08globalexception.exception;

import com.zjw.springboot08globalexception.myEnum.BusinessMsgEnum;

/**
 * 自定义业务异常
 */
public class BusinessErrorException extends RuntimeException{
    private static final long serialVersionUID=-42L;
    //异常码
    private String code;
    //异常信息
    private String msg;

    public BusinessErrorException(BusinessMsgEnum msgEnum) {
        this.code=msgEnum.getCode();
        this.msg=msgEnum.getMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
