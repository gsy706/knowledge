/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.configclient.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-07-25
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }

}
