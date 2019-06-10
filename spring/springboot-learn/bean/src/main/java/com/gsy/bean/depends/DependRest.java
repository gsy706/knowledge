/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.bean.depends;

import com.gsy.bean.depends.bean.LoadIfBeanExist;
import com.gsy.bean.depends.bean.LoadIfBeanNotExists;
import com.gsy.bean.depends.clz.LoadIfClzExists;
import com.gsy.bean.depends.clz.LoadIfClzNotExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-10
 */
@RestController
@RequestMapping("/depends")
public class DependRest {

    @Autowired(required = false)
    private LoadIfBeanExist loadIfBeanExist;
    @Autowired
    private LoadIfBeanNotExists loadIfBeanNotExists;
    @Autowired
    private LoadIfClzExists loadIfClzExists;
    @Autowired(required = false)
    private LoadIfClzNotExists loadIfClzNotExists;

    @GetMapping("/show")
    public Map<String, String> show(){
        Map<String, String> result = new HashMap<>(4);
        // 存在
        result.put("loadIfBeanExist", loadIfBeanExist == null ? "null ==> false!" : loadIfBeanExist.getName());
        // 存在
        result.put("loadIfBeanNotExists", loadIfBeanNotExists == null ? "null ==> false!" : loadIfBeanNotExists.getName());
        // 存在
        result.put("loadIfClzExists", loadIfClzExists == null ? "null ==> false!" : loadIfClzExists.getName());
        // 存在
        result.put("loadIfClzNotExists", loadIfClzNotExists == null ? "null ==> false!" : loadIfClzNotExists.getName());

        return result;
    }
}
