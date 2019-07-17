///**
// * Copyright © 2010-2019 Everyday Chain. All rights reserved.
// */
//package com.gsy.redis.config;
//
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisPassword;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
//import org.springframework.data.redis.core.RedisTemplate;
//import java.time.Duration;
//
///**
// * TODO
// *
// * @author: gusiyuan
// * @date: 2019-07-04
// */
//@Configuration
//public class RedisAutoConfig{
//
//    @Bean(initMethod = "init")
//    public AA aa(){
//        return new AA();
//    }
//
//    @Bean
//    public LettuceConnectionFactory defaultLettuceConnectionFactory(RedisStandaloneConfiguration defaultRedisConfig,
//                                                                    GenericObjectPoolConfig defaultPoolConfig) {
//        LettuceClientConfiguration clientConfig =
//                LettucePoolingClientConfiguration.builder().commandTimeout(Duration.ofMillis(100))
//                        .poolConfig(defaultPoolConfig).build();
//        return new LettuceConnectionFactory(defaultRedisConfig, clientConfig);
//    }
//
//    @Bean(name = "redisTemplate")
//    public RedisTemplate<String, String> defaultRedisTemplate(
//            LettuceConnectionFactory defaultLettuceConnectionFactory) {
//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(defaultLettuceConnectionFactory);
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
//
//    @Bean
//    @ConditionalOnBean(name = "localRedisConfig")
//    public LettuceConnectionFactory localLettuceConnectionFactory(RedisStandaloneConfiguration localRedisConfig,
//                                                                  GenericObjectPoolConfig localPoolConfig) {
//        LettuceClientConfiguration clientConfig =
//                LettucePoolingClientConfiguration.builder().commandTimeout(Duration.ofMillis(100))
//                        .poolConfig(localPoolConfig).build();
//        return new LettuceConnectionFactory(localRedisConfig, clientConfig);
//    }
//
//    @Bean
//    @ConditionalOnBean(name = "localLettuceConnectionFactory")
//    public RedisTemplate<String, String> localRedisTemplate(LettuceConnectionFactory localLettuceConnectionFactory) {
//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(localLettuceConnectionFactory);
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
//
//    @Configuration
//    @ConditionalOnProperty(name = "host", prefix = "spring.local-redis")
//    public static class LocalRedisConfig {
//        @Value("${spring.local-redis.host}")
//        private String host;
//        @Value("${spring.local-redis.port}")
//        private Integer port;
//        @Value("${spring.local-redis.password}")
//        private String password;
//        @Value("${spring.local-redis.database}")
//        private Integer database;
//
//        @Value("${spring.local-redis.lettuce.pool.max-active}")
//        private Integer maxActive;
//        @Value("${spring.local-redis.lettuce.pool.max-idle}")
//        private Integer maxIdle;
//        @Value("${spring.local-redis.lettuce.pool.max-wait}")
//        private Long maxWait;
//        @Value("${spring.local-redis.lettuce.pool.min-idle}")
//        private Integer minIdle;
//
//        @Bean
//        public GenericObjectPoolConfig localPoolConfig(){
//            GenericObjectPoolConfig config = new GenericObjectPoolConfig();
//            config.setMaxTotal(maxActive);
//            config.setMaxIdle(maxIdle);
//            config.setMinIdle(minIdle);
//            config.setMaxWaitMillis(maxWait);
//            return config;
//        }
//
//        @Bean
//        public RedisStandaloneConfiguration localRedisConfig() {
//            RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
//            config.setHostName(host);
//            config.setPassword(RedisPassword.of(password));
//            config.setPort(port);
//            config.setDatabase(database);
//            return config;
//        }
//    }
//
//    @Configuration
//    public static class DefaultRedisConfig {
//        @Value("${spring.redis.host}")
//        private String host;
//        @Value("${spring.redis.port}")
//        private Integer port;
//        @Value("${spring.redis.password}")
//        private String password;
//        @Value("${spring.redis.database}")
//        private Integer database;
//
//        @Value("${spring.redis.lettuce.pool.max-active}")
//        private Integer maxActive;
//        @Value("${spring.redis.lettuce.pool.max-idle}")
//        private Integer maxIdle;
//        @Value("${spring.redis.lettuce.pool.max-wait}")
//        private Long maxWait;
//        @Value("${spring.redis.lettuce.pool.min-idle}")
//        private Integer minIdle;
//
//        @Bean
//        public GenericObjectPoolConfig defaultPoolConfig() {
//            GenericObjectPoolConfig config = new GenericObjectPoolConfig();
//            config.setMaxTotal(maxActive);
//            config.setMaxIdle(maxIdle);
//            config.setMinIdle(minIdle);
//            config.setMaxWaitMillis(maxWait);
//            return config;
//        }
//
//        @Bean
//        public RedisStandaloneConfiguration defaultRedisConfig() {
//            RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
//            config.setHostName(host);
//            config.setPassword(RedisPassword.of(password));
//            config.setPort(port);
//            config.setDatabase(database);
//            return config;
//        }
//    }
//
//}
