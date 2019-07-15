/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.redis.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-07-15
 */
public class AA {

    public void init(){
        System.out.println("init AA");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("PostConstruct");
    }

    public AA() {
        System.out.println("AAAA");
    }
}
