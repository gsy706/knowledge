/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo;

import com.spring.demo.beanExtendDemo.Class1;
import com.spring.demo.beanExtendDemo.Class2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-01
 */
public class BeanExtendTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Class1 class1 = context.getBean("class1", Class1.class);
        System.out.println(class1);
        Class2 class2 = context.getBean("class2", Class2.class);
        System.out.println(class2);
    }

}
