/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.aop.demo2;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 这个bean下的方法，演示正则方式的拦截
 * 注意前面的参数为..，表示任意参数类型和个数的方法都会拦截
 * com.gsy.aop.demo2
 * @author: gusiyuan
 * @date: 2019-06-24
 */
@Component
public class PrintDemo {

    public String getRand(int seed, String suffix){
        return seed + UUID.randomUUID().toString() + suffix;
    }

}
