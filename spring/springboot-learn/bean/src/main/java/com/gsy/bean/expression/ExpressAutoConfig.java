/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.bean.expression;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-11
 */
@Configuration
public class ExpressAutoConfig {

    /**
     * 当存在配置且配置为true时才创建这个bean
     * @author: gusiyuan
     * @date: 2019-06-11
     */
    @Bean
    @ConditionalOnExpression("#{'true'.equals(environment.getProperty('conditional.express'))}")
    public ExpressTrueBean expressTrueBean(){
        return new ExpressTrueBean("express true");
    }

    /**
     * 配置不存在，或配置的值不是true时，才创建bean
     * @author: gusiyuan
     * @date: 2019-06-11
     */
    @Bean
    @ConditionalOnExpression("#{'false'.equals(environment.getProperty('conditional.express'))}")
    public ExpressFalseBean expressFalseBean(){
        return new ExpressFalseBean("express false");
    }

}
