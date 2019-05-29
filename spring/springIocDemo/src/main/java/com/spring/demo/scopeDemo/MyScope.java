/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo.scopeDemo;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-05-29
 */
public class MyScope implements Scope {

    private Map<String, Object> map1 = new ConcurrentHashMap<>();
    private Map<String, Object> map2 = new ConcurrentHashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (!map1.containsKey(name)) {
            Object obj = objectFactory.getObject();
            map1.put(name, obj);
            return obj;
        }
        if (!map2.containsKey(name)) {
            Object obj = objectFactory.getObject();
            map2.put(name, obj);
            return obj;
        }
        int i = new Random().nextInt(2);
        if (i ==0) {
            return map1.get(name);
        }else {
            return map2.get(name);
        }
    }

    @Override
    public Object remove(String name) {
        if (map2.containsKey(name)) {
            Object obj = map2.get(name);
            map2.remove(name);
            return obj;
        }
        if (map1.containsKey(name)) {
            Object obj = map1.get(name);
            map1.remove(name);
            return obj;
        }
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
