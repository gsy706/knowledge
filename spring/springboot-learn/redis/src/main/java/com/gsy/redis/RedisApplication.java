package com.gsy.redis;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisReactiveAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;

import java.util.concurrent.TimeUnit;

//@EnableAutoConfiguration(exclude = {RedisAutoConfiguration.class, RedisReactiveAutoConfiguration.class})
@SpringBootApplication
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

//    public RedisApplication(RedisTemplate<String, String> redisTemplate){
//        String key = redisTemplate.opsForValue().get("key");
//        System.out.println("value:" + key);
//    }

//    public RedisApplication(RedisTemplate<String, String> redisTemplate){
//        redisTemplate.opsForValue().set("hello","world");
//        String ans = redisTemplate.opsForValue().get("hello");
//        Assert.isTrue("world".equals(ans));
//    }

//    public RedisApplication(@Qualifier("localRedisTemplate") RedisTemplate<String, String> localRedisTemplate,
//                       @Qualifier("redisTemplate") RedisTemplate<String, String> defaultRedisTemplate)
//            throws InterruptedException {
//        // 10s的有效时间
//        localRedisTemplate.delete("key");
//        localRedisTemplate.opsForValue().set("key", "value", 100, TimeUnit.MILLISECONDS);
//        String ans = localRedisTemplate.opsForValue().get("key");
//        System.out.println("value".equals(ans));
//        TimeUnit.MILLISECONDS.sleep(200);
//        ans = localRedisTemplate.opsForValue().get("key");
//        System.out.println("value".equals(ans) + " >> false ans should be null! ans=[" + ans + "]");
//
//
//        defaultRedisTemplate.opsForValue().set("key", "value", 100, TimeUnit.MILLISECONDS);
//        ans = defaultRedisTemplate.opsForValue().get("key");
//        System.out.println(ans);
//    }
}
