package com.emo.rabbitmq.work;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: sher xia
 * @create: 2021-11-16 18:14
 */
@Slf4j
public class FanoutSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String exchangeName = "exchange.fanout";

    public void send(int index) {
        StringBuilder builder = new StringBuilder("hello");
        int limitIndex = index%3 + 1;
        for(int i =0; i<limitIndex; i++) {
            builder.append(".");
        }
        builder.append(index+1);
        String message = builder.toString();
        rabbitTemplate.convertAndSend(exchangeName, "", message);
        log.info(" [X] Sent '{}'", message);
    }
}
