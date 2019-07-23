/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.rocketmq.component;

import com.gsy.rocketmq.config.MessageEvent;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-07-23
 */
@Component
public class ConsumerService {

    @EventListener(condition = "")
    public void rocketMsgListener(MessageEvent event) {
        List<MessageExt> msgs = event.getMsgs();
        for (MessageExt msg : msgs) {
            System.out.println("消费消息：" + new String(msg.getBody()));
        }
    }

}
