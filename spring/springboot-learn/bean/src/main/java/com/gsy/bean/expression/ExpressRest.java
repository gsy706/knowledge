/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.bean.expression;

import com.alibaba.fastjson.JSONObject;
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
 * @date: 2019-06-11
 */
@RestController
@RequestMapping("/express")
public class ExpressRest {

    @Autowired(required = false)
    private ExpressTrueBean expressTrueBean;
    @Autowired(required = false)
    private ExpressFalseBean expressFalseBean;

    @GetMapping("/show")
    public String show(){
        Map<String, String> map = new HashMap<>(4);
        map.put("expressTrueBean", expressTrueBean == null ? "null ==> false" : expressTrueBean.getName());
        map.put("expressFalseBean", expressFalseBean == null ? "null ==> true": expressFalseBean.getName());
        return JSONObject.toJSONString(map);
    }

}
