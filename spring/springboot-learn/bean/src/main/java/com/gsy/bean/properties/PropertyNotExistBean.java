/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.bean.properties;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-11
 */
public class PropertyNotExistBean {

    private String name;

    public PropertyNotExistBean(String name) {
        this.name = name;
    }

    public String getName() {
        return "no property" + name;
    }

}
