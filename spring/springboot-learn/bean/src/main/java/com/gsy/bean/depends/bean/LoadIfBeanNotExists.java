/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.bean.depends.bean;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-10
 */
public class LoadIfBeanNotExists {

    public String name;

    public LoadIfBeanNotExists(String name) {
        this.name = name;
    }

    public String getName() {
        return "load if bean not exists: " + name;
    }

}
