/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.configclient.amqp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-07-25
 */
@Slf4j
@Component
@RabbitListener(queues = "hello")
public class Receiver {

    @RabbitHandler
    public void process(String hello) {
        log.info("Receiver：{}",hello);
    }

}
