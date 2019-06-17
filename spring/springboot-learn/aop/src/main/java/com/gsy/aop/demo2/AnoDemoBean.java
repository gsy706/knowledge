/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.aop.demo2;

import com.gsy.aop.annotation.AnoDot;
import com.gsy.aop.demo.DemoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-14
 */
@Component
public class AnoDemoBean {

    @Autowired
    private DemoBean demoBean;
    @Autowired
    private ScopeDemoBean scopeDemoBean;

    @AnoDot
    public String getUUID(long time) {
        try {
            System.out.println("getUUID before process!");
            return UUID.randomUUID() + "|" + time;
        } finally {
            System.out.println("getUUID end!");
        }
    }

    @AnoDot
    public String randUUID(long time) {
        try {
            System.out.println("randUUID before process!");
            return getUUID(time) + "<<<>>>" + demoBean.randUUID(time);
        } finally {
            System.out.println("randUUID finally!");
        }
    }

    public void scopeUUID(long time) {
        try {
            System.out.println("-------- default --------");
            String defaultAns = scopeDemoBean.defaultRandUUID(time);
            System.out.println("-------- default: " + defaultAns + " --------\n");


            System.out.println("-------- protected --------");
            String protectedAns = scopeDemoBean.protectedRandUUID(time);
            System.out.println("-------- protected: " + protectedAns + " --------\n");


            System.out.println("-------- private --------");
            // 利用反射调用private方法
            Method method = ScopeDemoBean.class.getDeclaredMethod("privateRandUUID", long.class);
            // 设置反射的对象应该禁止Java语言访问
            method.setAccessible(true);
            String privateAns = (String) method.invoke(scopeDemoBean, time);
            System.out.println("-------- private: " + privateAns + " --------\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
