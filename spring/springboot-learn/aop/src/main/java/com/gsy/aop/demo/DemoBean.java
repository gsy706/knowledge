/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.aop.demo;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-13
 */
@Component
public class DemoBean {

    /**
     * 返回随机字符串
     * @author: gusiyuan
     * @date: 2019-06-13
     */
    public String randUUID(long time){
        try {
            System.out.println("randUUID before process!");
            return UUID.randomUUID() + "|" + time;
        } finally {
            System.out.println("randUUID finally!");
        }
    }

}
