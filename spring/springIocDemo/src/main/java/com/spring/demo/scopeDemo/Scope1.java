/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo.scopeDemo;

import lombok.Data;
import lombok.ToString;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-05-28
 */
@Data
//@ToString
public abstract class Scope1 {

//    private Scope2 scope2;

    protected abstract Scope2 createScope2();

    public void printScope2(){
        System.out.println(createScope2());
    }

}
