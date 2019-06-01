/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo;

import com.spring.demo.annotationDemo.Annotation;
import com.spring.demo.annotationDemo.MyConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-01
 */
public class AnnotationTest {

    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        Annotation annotation = context.getBean("annotation", Annotation.class);
        System.out.println("annotation = " + annotation);
        for (String string : annotation.getStringList()) {
            System.out.println("string = " + string);
        }
        for (Map.Entry<String, Integer> integerEntry : annotation.getIntegerMap().entrySet()) {
            System.out.println("entry：" + integerEntry);
        }
    }

}
