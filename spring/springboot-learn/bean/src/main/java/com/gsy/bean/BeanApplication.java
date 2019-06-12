package com.gsy.bean;

import com.gsy.bean.choose.sameName.a.SameA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SameA.class)})
public class BeanApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeanApplication.class, args);
    }

}
