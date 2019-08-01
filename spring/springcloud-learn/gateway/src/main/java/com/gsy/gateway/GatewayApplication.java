package com.gsy.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//        // 让请求"/get"请求都转发到"http://httpbin.org/get"
//        // 在route配置上，我们添加了一个filter，该filter会将请求添加一个header,key为hello，value为world
//        return builder.routes()
//                .route(p -> p
//                        .path("/get")
//                        // 对请求做各种判断和修改
//                        .filters(f -> f.addRequestHeader("Hello", "World"))
//                        .uri("http://httpbin.org:80"))
//                .build();
//    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        String httpUri = "http://httpbin.org:80";
        // 让请求"/get"请求都转发到"http://httpbin.org/get"
        // 在route配置上，我们添加了一个filter，该filter会将请求添加一个header,key为hello，value为world
        return builder.routes()
                .route(predicateSpec -> predicateSpec
                        .path("/get")
                        // 对请求做各种判断和修改
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.addRequestHeader("Hello", "World"))
                        .uri(httpUri))
                // 使用host去断言请求是否进入该路由，当请求的host有“*.hystrix.com”，都会进入该router，
                // 该router中有一个hystrix的filter,该filter可以配置名称、和指向性fallback的逻辑的地址，比如本案例中重定向到了“/fallback”
                .route(predicateSpec -> predicateSpec
                        .host("*.hystrix.com")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.hystrix(config -> config
                                .setName("mycmd").setFallbackUri("forward:/fallback")))
                        .uri(httpUri))
                .build();
    }

    @GetMapping("/fallback")
    public Mono<String> fallback(){
        return Mono.just("fallback");
    }

}
