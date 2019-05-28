/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo;

import com.spring.demo.diDemo.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-05-28
 */
public class DiDemoTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println("book.getNameList() = " + book.getNameList());
        System.out.println("book.getAnotherBookList() = " + book.getAnotherBookList());
        System.out.println("book.getNameMap() = " + book.getNameMap());
        System.out.println("book.getAnotherBookMap() = " + book.getAnotherBookMap());
        System.out.println("book.getNameSet() = " + book.getNameSet());
        System.out.println("book.getAnotherBookSet() = " + book.getAnotherBookSet());
        System.out.println("book.getProperties() = " + book.getProperties());
        System.out.println("book.getAnotherBook2() = " + book.getAnotherBook2());

        System.out.println();

        // 获取JVM的系统属性
        Properties pps = System.getProperties();
        pps.list(System.out);
    }
}
