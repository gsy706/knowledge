/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo;

import com.spring.demo.scopeDemo.CustomScope;
import com.spring.demo.scopeDemo.TestConfiguration;
import com.spring.demo.scopeDemo.TestMyScope;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-05-29
 */
public class MyScopeDemoTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        for (int i = 0; i < 10; i++) {
            TestMyScope testMyScope = context.getBean("testMyScope", TestMyScope.class);
            System.out.println("bean = " + testMyScope);
        }
        System.out.println("================");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                TestMyScope testMyScope = context.getBean("testMyScope", TestMyScope.class);
                System.out.println("bean = " + testMyScope);
            }).start();
        }
    }

    @Test
    public void test2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
        for (int i = 0; i < 10; i++) {
            CustomScope customScope1 = context.getBean("customScope1", CustomScope.class);
            System.out.println("customScope1 = " + customScope1);
        }
        System.out.println(" ============ ");
        for (int i = 0; i < 10; i++) {
            CustomScope customScope2 = context.getBean("customScope2", CustomScope.class);
            System.out.println("customScope2 = " + customScope2);
        }
    }

    @Test
    public void test3() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
        CustomScope customScope1 = context.getBean("customScope1", CustomScope.class);
        for (int i = 0; i < 10; i++) {
            customScope1.printCustomScope();
        }
    }

}
