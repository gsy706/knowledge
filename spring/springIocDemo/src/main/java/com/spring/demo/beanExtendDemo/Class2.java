/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo.beanExtendDemo;

import lombok.Data;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-01
 */
@Data
public class Class2 extends ParentClass{

    private String data7;
    private String data8;

    @Override
    public String toString() {
        return "Class2{" +
                "data1='" + getData1() + '\'' +
                ", data2='" + getData2() + '\'' +
                ", data3='" + getData3() + '\'' +
                ", data7='" + data7 + '\'' +
                ", data8='" + data8 + '\'' +
                '}';
    }
}
