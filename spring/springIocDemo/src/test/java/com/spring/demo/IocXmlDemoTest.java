/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo;

import com.spring.demo.bean.Bean;
import com.spring.demo.bean.Bean2;
import com.spring.demo.bean.Bean3;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-05-27
 */
public class IocXmlDemoTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        // 构造方法实例化bean
        Bean bean = context.getBean("bean", Bean.class);
        System.out.println("bean = " + bean);

        // 静态工厂实例化bean
        Bean2 bean2 = context.getBean("bean2", Bean2.class);
        System.out.println("bean2 = " + bean2);

        // 实例工厂实例化bean
        Bean3 bean3 = context.getBean("bean3", Bean3.class);
        System.out.println("bean3 = " + bean3);

        // 使用别名
        Bean bean_1 = context.getBean("bean_1", Bean.class);
        System.out.println("bean_1 = " + bean_1);
        Bean bean_2 = context.getBean("bean_2", Bean.class);
        System.out.println("bean_2 = " + bean_2);
        Bean bean_3 = context.getBean("bean_3", Bean.class);
        System.out.println("bean_3 = " + bean_3);

    }

}
