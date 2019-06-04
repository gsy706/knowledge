/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo.scopeDemo;

import com.spring.demo.lifeCircleDemo.LifeCircle;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-03
 */
@Configuration
@ComponentScan(value = {"com.spring.demo.scopeDemo","com.spring.demo.lifeCircleDemo"})
public class TestConfiguration {

//    @Bean("customScope2")
//    @Scope("myScope")
//    public CustomScope customScope(){
//        return new CustomScope();
//    }

    @Bean
    public MyScope myScope(){
        return new MyScope();
    }

    @Bean
    public CustomScopeConfigurer customScopeConfigurer(){
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("myScope", myScope());
        return configurer;
    }

    @Bean(initMethod = "onInit1", destroyMethod = "onDestroy1")
    public LifeCircle lifeCircle(){
        return new LifeCircle();
    }

}
