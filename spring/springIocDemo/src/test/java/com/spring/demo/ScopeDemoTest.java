/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo;

import com.spring.demo.scopeDemo.Scope1;
import com.spring.demo.scopeDemo.Scope2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-05-28
 */
public class ScopeDemoTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        Scope2 scope2_1 = context.getBean("scope2", Scope2.class);
//        System.out.println("scope2_1 = " + scope2_1);
//        Scope2 scope2_2 = context.getBean("scope2", Scope2.class);
//        System.out.println("scope2_2 = " + scope2_2);
//        Scope1 scope1 = context.getBean("scope1", Scope1.class);
//        System.out.println("scope1 = " + scope1);
//
//        // 只能保证一个上下文环境下的单例模式
//        ApplicationContext context1 = new ClassPathXmlApplicationContext("spring.xml");
//        Scope2 scope2_3 = context1.getBean("scope2", Scope2.class);
//        System.out.println("scope2_3 = " + scope2_3);
//        Scope2 scope2_4 = context1.getBean("scope2", Scope2.class);
//        System.out.println("scope2_4 = " + scope2_4);

        Scope1 scope1_1 = context.getBean("scope1", Scope1.class);
//        System.out.println("scope1_1 = " + scope1_1);
//        Scope1 scope1_2 = context.getBean("scope1", Scope1.class);
//        System.out.println("scope1_2 = " + scope1_2);
//        System.out.println("(scope1_1 == scope1_2) = " + (scope1_1 == scope1_2));
        scope1_1.printScope2();
        scope1_1.printScope2();
        scope1_1.printScope2();
    }

}
