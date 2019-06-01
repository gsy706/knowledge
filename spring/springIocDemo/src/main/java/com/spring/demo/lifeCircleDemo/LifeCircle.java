/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo.lifeCircleDemo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-01
 */
public class LifeCircle implements InitializingBean, DisposableBean {

    public void onInit(){
        System.out.println("LifeCircle.onInit");
    }

    public void onDestroy(){
        System.out.println("LifeCircle.onDestroy");
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
