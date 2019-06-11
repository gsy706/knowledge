/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.bean.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-11
 */
@Configuration
public class PropertyAutoConfig {

    @Autowired
    private Environment environment;

    /**
     * 配置存在时才会加载这个bean
     * @author: gusiyuan
     * @date: 2019-06-11
     */
    @Bean
    @ConditionalOnProperty("conditional.property")
    public PropertyExistBean propertyExistBean(){
        return new PropertyExistBean(environment.getProperty("conditional.property"));
    }

    /**
     * 即便配置不存在时，也可以加载这个bean
     * @author: gusiyuan
     * @date: 2019-06-11
     */
    @Bean
    @ConditionalOnProperty(name = "conditional.property.no", matchIfMissing = true)
    public PropertyNotExistBean propertyNotExistBean(){
        return new PropertyNotExistBean("conditional.property");
    }

    /**
     * 要求配置存在并包含properExists值
     * @author: gusiyuan
     * @date: 2019-06-11
     */
    @Bean
    @ConditionalOnProperty(name = "conditional.property", havingValue = "properExists")
    public PropertyValueExistBean propertyValueExistBean(){
        return new PropertyValueExistBean("properExists");
    }

    /**
     * 要求配置存在并包含properNotExists值
     * @author: gusiyuan
     * @date: 2019-06-11
     */
    @Bean
    @ConditionalOnProperty(name = "conditional.property", havingValue = "properNotExists")
    public PropertyValueNotExistBean propertyValueNotExistBean() {
        return new PropertyValueNotExistBean("properNotExists");
    }
}
