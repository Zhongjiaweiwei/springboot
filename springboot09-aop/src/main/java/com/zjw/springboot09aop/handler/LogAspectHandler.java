package com.zjw.springboot09aop.handler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * //正常
 * //=====around before=====
 * //=====before=====
 * //======CommonServiceImpl targetMethod1======
 * //=====afterReturning=====
 *  * //=====after=====
 *  * //=====around after=====
 * //异常
 * //=====around before=====
 * //=====before=====
 * //======CommonServiceImpl targetMethod1======
 *  * //=====afterThrowing=====
 * //=====after=====
 * //java.lang.NullPointerException: name cannot be null
 *
 *
 * 这是一条环绕通知
 * 这是一条前置通知
 * 我就是要执行的方法
 * 这是一条后置通知success
 * 方法名:test
 * 属性:[]
 * 这是一条环绕通知
 */


@Aspect
@Component
public class LogAspectHandler {
    @Pointcut("execution(* com.zjw.springboot09aop.controller.*.*(..))")
    public void pointCut(){}

    //环绕通知
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){

        try{
            System.out.println("这是一条环绕通知");
            Object o = proceedingJoinPoint.proceed();
            System.out.println("这是一条环绕通知");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
    //前置通知
    @Before("pointCut()")
    public void before(){
        System.out.println("这是一条前置通知");
    }
    //后置通知
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        System.out.println("这是一条后置通知"+result);
    }
    //最终通知
    @After("pointCut()")
    public void after(JoinPoint joinPoint){
        //获取连接点所对应的签名信息(声明信息)
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("方法名:"+signature.getName());
        System.out.println("属性:"+ Arrays.toString(args));
    }
    //异常通知
    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Throwable ex){
        System.out.println("这是一条异常通知"+ex);
    }
}
