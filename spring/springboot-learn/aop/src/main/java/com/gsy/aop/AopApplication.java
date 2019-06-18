package com.gsy.aop;

import com.gsy.aop.demo.DemoBean;
import com.gsy.aop.demo2.AnoDemoBean;
import com.gsy.aop.order.InnerDemoBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopApplication {

    private AnoDemoBean anoDemoBean;

    private InnerDemoBean innerDemoBean;

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

//    public AopApplication(DemoBean demoBean){
//        String uuid = demoBean.randUUID(System.currentTimeMillis());
//        System.out.println("---------uuid：" + uuid + "----------");
//    }

//    public AopApplication(AnoDemoBean anoDemoBean){
//        this.anoDemoBean = anoDemoBean;
//        this.anoDemoBean();
//    }

//    public void anoDemoBean(){
//        System.out.println(">>>>>>>" + anoDemoBean.randUUID(System.currentTimeMillis()));
//    }
//    public void anoDemoBean(){
//        anoDemoBean.scopeUUID(System.currentTimeMillis());
//    }

    public AopApplication(InnerDemoBean innerDemoBean){
        this.innerDemoBean = innerDemoBean;
        this.innerDemoBean();
    }

    private void innerDemoBean() {
        System.out.println("result: " + innerDemoBean.print());
    }

}
