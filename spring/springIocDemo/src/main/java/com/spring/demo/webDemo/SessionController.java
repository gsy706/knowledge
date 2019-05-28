/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo.webDemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-05-28
 */
@RestController
public class SessionController {

    @RequestMapping("/testSession")
    public String test(){
        return this.toString();
    }

}
