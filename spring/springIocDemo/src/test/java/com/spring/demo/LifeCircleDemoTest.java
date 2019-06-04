/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo;

import com.spring.demo.lifeCircleDemo.LifeCircle;
import com.spring.demo.scopeDemo.TestConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-01
 */
public class LifeCircleDemoTest {

    @Test
    public void test(){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        LifeCircle lifeCircle = context.getBean("lifeCircle", LifeCircle.class);
        System.out.println("lifeCircle = " + lifeCircle);
        // 关闭上下文环境
        context.close();
    }

    @Test
    public void test1(){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
        LifeCircle lifeCircle = context.getBean("lifeCircle", LifeCircle.class);
        System.out.println("lifeCircle = " + lifeCircle);
        // 关闭上下文环境
        context.close();
    }

}
