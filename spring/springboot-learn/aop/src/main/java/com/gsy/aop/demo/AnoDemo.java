/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.aop.demo;

import com.gsy.aop.logAspect.AnoAop;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 这个bean下的方法，演示注解拦截
 * com.gsy.aop.demo.
 * @author: gusiyuan
 * @date: 2019-06-24
 */
@Component
public class AnoDemo {

    @AnoAop
    public String getUUID(String ans){
        return UUID.randomUUID() + "<>" + ans;
    }

}
