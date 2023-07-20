package com.zjw.springboot08globalexception.result;

/**
 * 封装统一返回结果
 */
public class JsonResult {
    //异常码
    private String code;
    //异常信息
    private String msg;

    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResult() {
        this.code="200";
        this.msg="操作成功";
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
