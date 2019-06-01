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
public class Class1 extends ParentClass{

    private String data4;
    private String data5;

    @Override
    public String toString() {
        return "Class1{" +
                "data1='" + getData1() + '\'' +
                ", data2='" + getData2() + '\'' +
                ", data3='" + getData3() + '\'' +
                ", data4='" + data4 + '\'' +
                ", data5='" + data5 + '\'' +
                '}';
    }
}
