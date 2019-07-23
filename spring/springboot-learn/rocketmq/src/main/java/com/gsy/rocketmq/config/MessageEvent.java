/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.rocketmq.config;

import lombok.Data;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-07-23
 */
@Data
public class MessageEvent extends ApplicationEvent {

    private DefaultMQPushConsumer consumer;
    private List<MessageExt> msgs;

    public MessageEvent(List<MessageExt> msgs, DefaultMQPushConsumer consumer) {
        super(msgs);
        this.consumer = consumer;
        this.msgs = msgs;
    }

}
