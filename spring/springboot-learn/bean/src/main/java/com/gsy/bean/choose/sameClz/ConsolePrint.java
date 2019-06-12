/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.bean.choose.sameClz;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-12
 */
@Component
public class ConsolePrint implements IPrint{

    @Override
    public void print(String msg) {
        System.out.println("console print: "+ msg);
    }
}
