package com.zjw.springboot08globalexception.myEnum;

/**
 * 常见异常枚举类
 */
public enum BusinessMsgEnum {

    /** 参数异常 */
    PARMETER_EXCEPTION("102", "参数异常!"),
    /** 等待超时 */
    SERVICE_TIME_OUT("103", "服务调用超时！"),
    /** 参数过大 */
    PARMETER_BIG_EXCEPTION("102", "输入的图片数量不能超过50张!"),
    /** 500 : 一劳永逸的提示也可以在这定义 */
    UNEXPECTED_EXCEPTION("500", "系统发生异常，请联系管理员！");

    //消息码
    private String code;
    //消息内容
    private String msg;
    BusinessMsgEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    BusinessMsgEnum() {
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
