/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.bean.depends.clz;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-10
 */
public class LoadIfClzExists {

    private String name;

    public LoadIfClzExists(String name) {
        this.name = name;
    }

    public String getName() {
        return "load if exists clz: " + name;
    }

}
