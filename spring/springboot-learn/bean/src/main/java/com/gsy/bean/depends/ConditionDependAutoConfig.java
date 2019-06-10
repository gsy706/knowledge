/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.bean.depends;

import com.gsy.bean.depends.bean.DependedBean;
import com.gsy.bean.depends.bean.LoadIfBeanExist;
import com.gsy.bean.depends.bean.LoadIfBeanNotExists;
import com.gsy.bean.depends.clz.DependedClz;
import com.gsy.bean.depends.clz.LoadIfClzExists;
import com.gsy.bean.depends.clz.LoadIfClzNotExists;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-10
 */
@Configuration
public class ConditionDependAutoConfig {

    @Bean
    public DependedBean dependedBean(){
        return new DependedBean();
    }

    /**
     * 只有当DependedBean 存在时，才会创建bean: `LoadIfBeanExist`
     * @author: gusiyuan
     * @date: 2019-06-10
     */
    @Bean
    @ConditionalOnBean(name = "dependedBean")
    public LoadIfBeanExist loadIfBeanExist(){
        return new LoadIfBeanExist("dependedBean");
    }

    /**
     * 只有当没有notExistsBean时，才会创建bean: `LoadIfBeanNotExists`
     * @author: gusiyuan
     * @date: 2019-06-10
     */
    @Bean
    @ConditionalOnMissingBean(name = "notExistsBean")
    public LoadIfBeanNotExists loadIfBeanNotExists(){
        return new LoadIfBeanNotExists("notExistsBean");
    }

    /**
     * 当引用了 {@link DependedClz} 类之后，才会创建bean： `LoadIfClzExists`
     * @author: gusiyuan
     * @date: 2019-06-10
     */
    @Bean
    @ConditionalOnClass(DependedClz.class)
    public LoadIfClzExists loadIfClzExists(){
        return new LoadIfClzExists("dependedClz");
    }

    /**
     * 当系统中没有 com.gsy.bean.depends.clz.DependedClz类时，才会创建这个bean
     * @author: gusiyuan
     * @date: 2019-06-10
     */
    @Bean
    @ConditionalOnMissingClass("com.gsy.bean.depends.clz.DependedClz")
    public LoadIfClzNotExists loadIfClzNotExists() {
        return new LoadIfClzNotExists("com.gsy.bean.depends.clz.DependedClz");
    }

}
