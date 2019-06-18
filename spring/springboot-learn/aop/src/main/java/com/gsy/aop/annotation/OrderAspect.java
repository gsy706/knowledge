/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-18
 */
@Order(0)
@Aspect
@Component
public class OrderAspect {

    @Pointcut("execution(public * com.gsy.aop.order.*.*())")
    public void point(){
    }

    @Order(1)
    @Before(value = "point()")
    public void doBefore(){
        System.out.println("do before!");
    }

    @After(value = "point()")
    public void daAfter(){
        System.out.println("do after!");
    }

    @AfterReturning(value = "point()", returning = "ans")
    public void doAfterReturning(String ans){
        System.out.println("do after return: " + ans);
    }

    @Around("point()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            System.out.println("do around before");
            return joinPoint.proceed();
        } finally {
            System.out.println("do around end!");
        }
    }

    @Order(2)
    @Before("@annotation(AnoDot)")
    public void doAnoBefore(){
        System.out.println("do AnoBefore");
    }

    @Order(3)
    @Before("@annotation(AnoDot)")
    public void doXBefore() {
        System.out.println("do XBefore");
    }
}
