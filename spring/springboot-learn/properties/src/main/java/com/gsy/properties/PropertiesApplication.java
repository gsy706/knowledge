package com.gsy.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class PropertiesApplication {

    public static void main(String[] args) {
        if (args.length > 0) {
            SpringApplication.run(PropertiesApplication.class, "--spring.profiles.active=" + args[0] + ",biz");
        } else {
            SpringApplication.run(PropertiesApplication.class);
        }
    }

    /**
     * 测试多环境配置选择
     * @author: gusiyuan
     * @date: 2019-06-04
     */
    public void testMultEnvChoose(Environment environment) {
        String env = environment.getProperty("biz.env");

        String whitelist = environment.getProperty("biz.whitelist");
        String ratelimit = environment.getProperty("biz.ratelimit");

        String total = environment.getProperty("biz.total");
        String profile = environment.getProperty("biz.profile");

        // application.yml文件中的配置 spring.profile.active指定具体选中的配置文件，为 application-dev 和 application-biz
        // read from application-dev.yml
        System.out.println("env: " + env);

        // read from application-biz.yml
        System.out.println("whitelist: " + whitelist);
        System.out.println("ratelimit: " + ratelimit);


        // 当配置文件 application.yml, application-dev.yml, application-biz.yml 三个文件都存在时，覆盖规则为
        // biz > dev > application.yml  （其中 biz>dev的原则是根据 spring.profile.active 中定义的顺序来的，最右边的优先级最高）
        // read from application-biz.yml
        System.out.println("total: " + total);

        // read from application-biz.yml
        System.out.println("profile: " + profile);
    }

    /**
     * 测试多环境配置选择
     * @author: gusiyuan
     * @date: 2019-06-04
     */
    public void testFileSort(Environment environment){
        String source = environment.getProperty("source");
        System.out.println(source);
    }

    public PropertiesApplication(Environment environment){
        testFileSort(environment);
    }

}
