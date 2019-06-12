/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.bean.choose.sameClz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-12
 */
@Component
public class NormalPrintDemo {

    @Resource(name = "consolePrint")
    private IPrint consolePrint;

    @Autowired
    private IPrint logPrint;

    @PostConstruct
    public void init(){
        consolePrint.print(" console print!!!");
        logPrint.print(" log print!!!");
    }

}
