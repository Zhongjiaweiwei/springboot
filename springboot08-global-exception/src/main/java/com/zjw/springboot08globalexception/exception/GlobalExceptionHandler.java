package com.zjw.springboot08globalexception.exception;

import com.zjw.springboot08globalexception.result.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


//@ControllerAdvice注解是Spring3.2中新增的注解，学名是Controller增强器，作用是给Controller控制器添加统一的操作或处理。
@ControllerAdvice
//给调用方输出一个json数据
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * POST 请求 需要携带一些参数，但是往往有时候参数会漏掉。
     * 另外，在微服务架构中，涉及到多个微服务之间的接口调用时，也可能出现这种情况，
     * 此时我们需要定义一个处理参数缺失异常的方法，来给前端或者调用方提示一个友好信息。
     * 参数缺失的时候，会抛出 HttpMessageNotReadableException，我们可以拦截该异常，做一个友好处理
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    //指定http状态码
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonResult handleHttpMessageNotReadableException(MissingServletRequestParameterException ex){
        logger.error("缺少请求参数，{}",ex.getMessage());
        return new JsonResult("400","缺少必要的请求参数");
    }
    /**
     * 空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handlerTypeMismatchException(NullPointerException ex){
        logger.error("空指针异常，{}",ex.getMessage());
        return new JsonResult("500","空指针异常");
    }

    /**
     * 系统异常预期以外的异常
     * 直接拦截Exception异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handlerUnexpectedServer(Exception ex){
        logger.error("系统异常:",ex);
        return new JsonResult("500","系统发生异常，请联系管理员");
    }
    /**
     * 拦截自定义业务异常
     * 返回业务异常信息
     */
    @ExceptionHandler(BusinessErrorException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handlerBusinessError(BusinessErrorException ex){
        return new JsonResult(ex.getCode(),ex.getMsg());
    }
}
