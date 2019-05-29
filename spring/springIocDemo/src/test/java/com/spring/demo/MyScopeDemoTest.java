/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo;

import com.spring.demo.scopeDemo.TestMyScope;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
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
            new Thread(new Runnable() {
                @Override
                public void run() {
                    TestMyScope testMyScope = context.getBean("testMyScope", TestMyScope.class);
                    System.out.println("bean = " + testMyScope);
                }
            }).start();
        }
    }

}
