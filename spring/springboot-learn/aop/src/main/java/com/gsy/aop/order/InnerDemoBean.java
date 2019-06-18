/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.aop.order;

import com.gsy.aop.annotation.AnoDot;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-18
 */
@Component
public class InnerDemoBean {

    @AnoDot
    public String print() {
        try {
            System.out.println("innerDemoBean start!");
            String rans = System.currentTimeMillis() + "|" + UUID.randomUUID();
            System.out.println(rans);
            return rans;
        } finally {
            System.out.println("innerDemoBean end!");
        }
    }

}
