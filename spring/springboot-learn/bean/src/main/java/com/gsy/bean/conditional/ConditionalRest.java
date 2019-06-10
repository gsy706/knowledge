/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.bean.conditional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-10
 */
@RestController
@RequestMapping("/conditional")
public class ConditionalRest {

    @Autowired
    private RandDataComponent randDataComponent;
    @Autowired(required = false)
    private ScanDemoBean scanDemoBean;
    @Autowired
    private Environment environment;

    @GetMapping("/show")
    public String show(){
        String type = environment.getProperty("conditional.rand.type");
        return randDataComponent.rand() + "————>" + type;
    }

    @GetMapping("/scan")
    public String scan(){
        String load = environment.getProperty("conditional.demo.load");
        if (scanDemoBean == null) {
            return "not exists ————>" + load;
        }
        return "load:" + scanDemoBean.getLoad() + "————>" + load;
    }

}
