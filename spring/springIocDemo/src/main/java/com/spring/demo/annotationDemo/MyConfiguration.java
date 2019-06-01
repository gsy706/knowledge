/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo.annotationDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-01
 */
@Configuration
@ComponentScan(basePackages = "com.spring.demo.annotationDemo")
public class MyConfiguration {

//    @Bean(value = {"annotation", "annotation1"})
//    @Bean({"annotation", "annotation1"})
//    public Annotation annotation(){
//        return new Annotation();
//    }

    /*@Bean("stringList")
    public List<String> stringList(){
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        return list;
    }*/

    /**
     * Order不需从0开始,不需连续，数字小的优先级高
     *
     * @author: gusiyuan
     * @date: 2019-06-01
     */
    @Bean
    @Order(30)
    public String string1() {
        return "ccc";
    }

    @Bean
    @Order(15)
    public String string2() {
        return "ddd";
    }

    @Bean
    public Map<String, Integer> integerMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("aaa", 111);
        map.put("bbb", 222);
        return map;
    }

    /**
     * key为bean名
     * @author: gusiyuan
     * @date: 2019-06-01
     */
    @Bean
    public Integer integer1(){
        return 333;
    }

    @Bean
    public Integer integer2(){
        return 444;
    }
}
