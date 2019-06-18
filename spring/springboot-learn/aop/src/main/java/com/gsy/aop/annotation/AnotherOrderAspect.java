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
@Order(10)
@Aspect
@Component
public class AnotherOrderAspect {

    @Before("@annotation(AnoDot)")
    public void doBefore(){
        System.out.println("AnotherOrderAspect before");
    }

    @After("@annotation(AnoDot)")
    public void doAfter() {
        System.out.println("do AnotherOrderAspect after!");
    }

    @AfterReturning(value = "@annotation(AnoDot)", returning = "ans")
    public void doAfterReturning(String ans) {
        System.out.println("do AnotherOrderAspect after return: " + ans);
    }

    @Around("@annotation(AnoDot)")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            System.out.println("do AnotherOrderAspect in around before");
            return joinPoint.proceed();
        } finally {
            System.out.println("do AnotherOrderAspect in around over!");
        }
    }

}
