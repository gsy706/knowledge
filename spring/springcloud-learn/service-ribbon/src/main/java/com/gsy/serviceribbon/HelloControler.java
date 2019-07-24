/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.serviceribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-07-24
 */
@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;

    @GetMapping("/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }

}
