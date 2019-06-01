/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo;

import com.spring.demo.lifeCircleDemo.LifeCircle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-01
 */
public class LifeCircleTest {

    @Test
    public void test(){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        LifeCircle lifeCircle = context.getBean("lifeCircle", LifeCircle.class);
        System.out.println("lifeCircle = " + lifeCircle);
        // 关闭上下文环境
        context.close();
    }

}
