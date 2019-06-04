/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo.lifeCircleDemo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-01
 */
@Component
public class LifeCircle implements InitializingBean, DisposableBean {

    @PostConstruct
    public void onInit(){
        System.out.println("LifeCircle.onInit");
    }

    @PreDestroy
    public void onDestroy(){
        System.out.println("LifeCircle.onDestroy");
    }

    public void onInit1(){
        System.out.println("LifeCircle.onInit1");
    }

    public void onDestroy1(){
        System.out.println("LifeCircle.onDestroy1");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("LifeCircle.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("LifeCircle.afterPropertiesSet");
    }
}
