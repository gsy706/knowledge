/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.bean.properties;

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
@RequestMapping("/property")
public class PropertyRest {

    @Autowired(required = false)
    private PropertyExistBean propertyExistBean;
    @Autowired(required = false)
    private PropertyNotExistBean propertyNotExistBean;
    @Autowired(required = false)
    private PropertyValueExistBean propertyValueExistBean;
    @Autowired(required = false)
    private PropertyValueNotExistBean propertyValueNotExistBean;

    @GetMapping("/show")
    public String show(){
        Map<String, String> map = new HashMap<>(4);
        // 存在
        map.put("propertyExistBean", propertyExistBean == null ? "null ===> false" : propertyExistBean.getName());
        // 存在
        map.put("propertyNotExistBean", propertyNotExistBean == null ? "null ===> false" : propertyNotExistBean.getName());
        // 存在
        map.put("propertyValueExistBean", propertyValueExistBean == null ? "null ==> false" : propertyValueExistBean.getName());
        // 不存在
        map.put("propertyValueNotExistBean", propertyValueNotExistBean == null ? "null ==> true" : propertyValueNotExistBean.getName());
        return JSONObject.toJSONString(map);
    }

}
