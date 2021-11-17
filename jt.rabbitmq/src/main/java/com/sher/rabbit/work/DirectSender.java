package com.sher.rabbit.work;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: sher xia
 * @create: 2021-11-17 10:53
 */
@Slf4j
public class DirectSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String exchangeName = "exchange.direct";

    private final String[] keys = {"orange", "black", "green"};

    public void send(int index) {
        StringBuilder builder = new StringBuilder("hello to ");
        int limitIndex = index % 3;
        String key = keys[limitIndex];
        builder.append(key).append(' ');
        builder.append(index+1);
        String message = builder.toString();
        rabbitTemplate.convertAndSend(exchangeName, key, message);
        log.info(" [X] Send '{}'", message);
    }
}
