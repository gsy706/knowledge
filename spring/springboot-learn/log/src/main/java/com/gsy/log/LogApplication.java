package com.gsy.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class LogApplication {

    public LogApplication() {
        log.debug("---> debug start! <------");
        log.info("---> info start! <------");
        log.warn("---> warn start! <------");
        log.error("---> error start! <------");

        System.out.println("===> System.out.println <=====");
    }

    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class, args);
    }

}
