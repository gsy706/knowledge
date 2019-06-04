/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo.scopeDemo;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-03
 */
@Component("customScope1")
@Scope("singleton")
@Lazy
public abstract class CustomScope {

    @Lookup
    public abstract MethodDIDemo methodDIDemo();

    public void printCustomScope(){
        System.out.println("customScope1 = " + methodDIDemo());
    }
}
