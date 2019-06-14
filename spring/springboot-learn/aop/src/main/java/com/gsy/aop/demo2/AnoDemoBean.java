/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.aop.demo2;

import com.gsy.aop.annotation.AnoDot;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-14
 */
@Component
public class AnoDemoBean {

    @AnoDot
    public String getUUID(long time){
        try {
            System.out.println("getUUID before process!");
            return UUID.randomUUID() + "|" + time;
        }finally {
            System.out.println("getUUID end!");
        }
    }

    public String randUUID(long time){
        try {
            System.out.println("randUUID before process!");
            return UUID.randomUUID() + "|" + time;
        } finally {
            System.out.println("randUUID finally!");
        }
    }

}
