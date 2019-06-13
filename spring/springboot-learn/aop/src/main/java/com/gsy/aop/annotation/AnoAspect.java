/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.aop.annotation;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-13
 */
@Aspect
@Component
public class AnoAspect {


    @Before("execution(public * com.gsy.aop.demo.*.*(*))")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("Aspect before method start! args：" + JSON.toJSONString(joinPoint.getArgs()));
    }

    @Pointcut("execution(public * com.gsy.aop.demo.*.*(*))")
    public void point(){
    }

    @After("point()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("Aspect after method start! args：" + JSON.toJSONString(joinPoint.getArgs()));
    }

    @AfterReturning(value = "point() && args(time)", returning = "result")
    public void doAfterReturning(long time, String result){
        System.out.println("Aspect after method return! args：" + time + "ans：" + result);
    }

    @Around("point()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Aspect around ——————> before");
        Object proceed = joinPoint.proceed();
        System.out.println("Aspect around ——————> end! ans：" + proceed);
        return proceed;
    }

}
