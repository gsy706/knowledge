/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-14
 */
@Component
@Aspect
public class NetAspect {

    @Around("@annotation(AnoDot)")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("NetAspect doAround before");
        Object ans = joinPoint.proceed();
        System.out.println("NetAspect doAround end! args：" + ans);
        return ans;
    }

}
