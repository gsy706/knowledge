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
 * @date: 2019-06-17
 */
@Component
public class ScopeDemoBean {

    @AnoDot
    String defaultRandUUID(long time) {
        try {
            System.out.println("ScopeDemoBean defaultRandUUID before!");
            return UUID.randomUUID() + " | default | " + time;
        } finally {
            System.out.println("ScopeDemoBean defaultRandUUID finally!");
        }
    }

    @AnoDot
    protected String protectedRandUUID(long time) {
        try {
            System.out.println("ScopeDemoBean protectedRandUUID before!");
            return UUID.randomUUID() + " | protected | " + time;
        } finally {
            System.out.println(" in ScopeDemoBean protectedRandUUID finally!");
        }
    }

    @AnoDot
    private String privateRandUUID(long time) {
        try {
            System.out.println("ScopeDemoBean privateRandUUID before!");
            return UUID.randomUUID() + " | private | " + time;
        } finally {
            System.out.println("ScopeDemoBean privateRandUUID finally!");
        }
    }

}
