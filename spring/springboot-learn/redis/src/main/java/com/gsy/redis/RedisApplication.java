package com.gsy.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;

@SpringBootApplication
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    public RedisApplication(RedisTemplate<String, String> redisTemplate){
        redisTemplate.opsForValue().set("hello","world");
        String ans = redisTemplate.opsForValue().get("hello");
        Assert.isTrue("world".equals(ans));
    }
}
