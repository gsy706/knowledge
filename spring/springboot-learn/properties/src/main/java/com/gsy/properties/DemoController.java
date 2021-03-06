/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.properties;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-04
 */
@RestController
public class DemoController {

    @Autowired
    private Environment environment;
    @Autowired
    private ProperBean properBean;
    @Autowired
    private OtherProperBean otherProperBean;
    @Autowired
    private ContextRefresher contextRefresher;
    @Autowired
    private ValueConfig valueConfig;
    @Autowired
    private BizConfig bizConfig;

    @Value("${rest.uuid}")
    private String uuid;
    @Value("${app.proper.key}")
    private String key;
    @Value("${app.proper.id}")
    private int id;
    @Value("${app.demo.val}")
    private String autoInject;
    // 配置app.demo.not不存在时,不抛异常,给一个默认值data
    @Value("${app.demo.not:data}")
    private String notExists;
    @Value("${user.name2}")
    private String name;

    @GetMapping("/show")
    public String show(){
        Map<String, String> map = new HashMap<>(4);
        map.put("env", environment.getProperty("server.port"));
        return JSON.toJSONString(map);
    }

    @GetMapping("/show2")
    public Map<String, String> show2(){
        Map<String, String> map = new HashMap<>(4);
        map.put("key", key);
        map.put("id", String.valueOf(id));
        map.put("autoInject", autoInject);
        map.put("not", notExists);
        return map;
    }

    @GetMapping("/show3")
    public Map<String, String> show3(){
        Map<String, String> map = new HashMap<>(8);
        map.put("env", environment.getProperty("server.port"));
        map.put("key", properBean.getKey());
        map.put("autoInject", autoInject);
        map.put("not", notExists);
        map.put("name", name);
        return map;
    }

    @GetMapping("/show4")
    public Map<String, String> show4(){
        Map<String, String> map = new HashMap<>(8);
        map.put("key", otherProperBean.getAppKey());
        map.put("uuid", otherProperBean.getUuid());
        return map;
    }

    @GetMapping("/show5")
    public String show5() {
        JSONObject res = new JSONObject();
        res.put("biz", JSONObject.toJSONString(bizConfig));
        res.put("uuid", valueConfig.getUuid());
        res.put("no-refresh", uuid);
        return res.toJSONString();
    }

    @GetMapping("/refresh")
    public String refresh(){
        new Thread(() -> contextRefresher.refresh()).start();
        return show5();
    }

    @EventListener
    public void eventListener(EnvironmentChangeEvent environmentChangeEvent){
        System.out.println("config change: " + environmentChangeEvent);
    }

}
