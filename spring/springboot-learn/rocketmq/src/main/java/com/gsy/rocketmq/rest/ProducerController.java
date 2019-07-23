/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.rocketmq.rest;

import com.alibaba.fastjson.JSON;
import com.gsy.rocketmq.entity.User;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 创建MQ消息生产者
 *
 * @author: gusiyuan
 * @date: 2019-07-23
 */
@RestController
public class ProducerController {

    @Autowired
    private DefaultMQProducer defaultProducer;
    @Autowired
    private TransactionMQProducer transactionProducer;

    @GetMapping("/sendMsg")
    /**
     * 发送普通消息
     * @author: gusiyuan
     * @date: 2019-07-23
     * @param
     * @return void
     */
    public void sendMsg() {
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setUserName("gsy_" + i);
            String json = JSON.toJSONString(user);
            try {
                Message msg = new Message("user-topic", "white", json.getBytes());
                SendResult sendResult = defaultProducer.send(msg);
                System.out.println("消息id：" + sendResult.getMsgId() + " ——> 发送状态："
                        + sendResult.getSendStatus());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//    @GetMapping("/sendTransactionMsg")
//    /**
//     * 发送事务消息
//     * @author: gusiyuan
//     * @date: 2019-07-23
//     * @param
//     * @return java.lang.String
//     */
//    public String TransactionMsg() {
//        SendResult sendResult = null;
//        // 发送事务消息
//        try {
//            String str = "c";
//            Message msg = new Message("user-tran-topic","black", str.getBytes());
//            sendResult = transactionProducer.sendMessageInTransaction(msg, (Message msg1, Object arg) -> {
//                String value = "";
//                if (arg instanceof String) {
//                    value = (String) arg;
//                }
//                if (value == "") {
//                    throw new RuntimeException("发送消息不能为空...");
//                } else if (value =="a") {
//                    return LocalTransactionState.ROLLBACK_MESSAGE;
//                } else if (value =="b") {
//                    return LocalTransactionState.COMMIT_MESSAGE;
//                }
//                return LocalTransactionState.ROLLBACK_MESSAGE;
//            }, 4);
//            System.out.println(sendResult);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return sendResult.toString();
//    }

    @GetMapping("/sendMsgOrder")
    public void sendMsgOrder() {
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setUserName("gsy_" + i);
            String json = JSON.toJSONString(user);
            Message msg = new Message("user-topic", "white", json.getBytes());
            SendResult sendResult = null;
            try {
                sendResult = defaultProducer.send(msg, new MessageQueueSelector() {
                    @Override
                    public MessageQueue select(List<MessageQueue> list, Message message, Object arg) {
                        int index = ((Integer) arg) % list.size();
                        return list.get(index);
                    }
                }, i);
                System.out.println("消息id：" + sendResult.getMsgId() + " ——> 发送状态："
                        + sendResult.getSendStatus());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
