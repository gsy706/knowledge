package com.gsy.aop;

import com.gsy.aop.demo.DemoBean;
import com.gsy.aop.demo2.AnoDemoBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopApplication {

    private AnoDemoBean anoDemoBean;

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    public AopApplication(DemoBean demoBean){
        String uuid = demoBean.randUUID(System.currentTimeMillis());
        System.out.println("---------uuid：" + uuid + "----------");
    }

//    public AopApplication(AnoDemoBean anoDemoBean){
//        this.anoDemoBean = anoDemoBean;
//        this.anoDemoBean();
//    }
//
//    public void anoDemoBean(){
//        System.out.println(">>>>>>>" + anoDemoBean.getUUID(System.currentTimeMillis()));
//    }

}
