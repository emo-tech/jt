package com.sher.rabbit.work;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: sher xia
 * @create: 2021-11-12 16:22
 */
@Slf4j
public class SimpleSender {

    @Autowired
    private RabbitTemplate template;

    private static final String queueName = "simple.hello";

    public void send() {
        String message = "hello world";
        this.template.convertAndSend(queueName, message);
        log.info("[x] Send '{}'", message);
    }
}
