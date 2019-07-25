/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.configclient.amqp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-07-25
 */
@Slf4j
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context = "hello" + LocalDateTime.now();
        log.info("Sender：{}",context);
        amqpTemplate.convertAndSend("hello", context);
    }

}
