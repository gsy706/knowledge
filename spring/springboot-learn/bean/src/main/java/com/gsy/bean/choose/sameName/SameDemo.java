/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.bean.choose.sameName;

import com.gsy.bean.choose.sameName.a.SameA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-12
 */
@Component
public class SameDemo {

    @Autowired
    private SameA sameA;

    @PostConstruct
    public void print(){
        sameA.print();
    }

}
