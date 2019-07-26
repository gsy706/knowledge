package com.gsy.zipkinservicemiya;

import brave.sampler.Sampler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@SpringBootApplication
public class ZipkinServiceMiyaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServiceMiyaApplication.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/hi")
    public String home(){
        log.info("hi is being called");
        return "hi i'm miya!";
    }

    @GetMapping("/miya")
    public String info(){
        log.info("info is being called");
        return restTemplate.getForObject("http://localhost:8988/info",String.class);
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
