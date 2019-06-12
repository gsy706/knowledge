/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.bean.choose.sameName.a;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-12
 */
@Component
public class SameA {

    private String text;

    public SameA(){
        text = "a sameA";
    }

    public void print(){
        System.out.println(text);
    }

}
