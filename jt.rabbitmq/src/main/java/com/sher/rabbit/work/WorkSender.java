package com.sher.rabbit.work;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: sher xia
 * @create: 2021-11-16 17:23
 */
@Slf4j
public class WorkSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String queueName = "work.hello";

    public void send(int index) {
        StringBuilder builder = new StringBuilder("hello");
        int limitIndex = index % 3 + 1;
        for (int i = 0; i< limitIndex; i++) {
            builder.append('.');
        }
        builder.append(index+1);
        String message = builder.toString();
        rabbitTemplate.convertAndSend(queueName, message);
        log.info("[X] Send '{}'", message);
    }
}
