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
public class PropertyExistBean {

    private String name;

    public PropertyExistBean(String name) {
        this.name = name;
    }

    public String getName() {
        return "property : " + name;
    }

}
