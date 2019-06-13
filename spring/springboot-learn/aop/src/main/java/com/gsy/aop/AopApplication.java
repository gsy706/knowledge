package com.gsy.aop;

import com.gsy.aop.demo.DemoBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    public AopApplication(DemoBean demoBean){
        String uuid = demoBean.randUUID(System.currentTimeMillis());
        System.out.println("---------uuid：" + uuid + "----------");
    }

}
