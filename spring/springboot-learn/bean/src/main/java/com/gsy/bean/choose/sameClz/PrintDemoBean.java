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
public class PrintDemoBean {

    @Resource(name = "logPrint")
    private IPrint print;

    @Autowired
    private IPrint consolePrint;

    @Autowired
    private IPrint logPrint;

    // logPrint的选择，由@Primary注解决定
    @Autowired(required = false)
    private IPrint xxxPrint;

    // 结果为输出LogPrint实例
    @PostConstruct
    public void init() {
        print.print("expect logPrint for [print]");
        consolePrint.print(" expect logPrint for [consolePrint]");
        logPrint.print("expect logPrint for [logPrint]");
        xxxPrint.print("expect logPrint for [xxxPrint]");
    }

}
