package com.sher.rabbit.work;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @description:
 * @author: sher xia
 * @create: 2021-11-12 16:26
 */
@Slf4j
@RabbitListener(queues = "simple.hello")
public class SimpleReceiver {

    @RabbitHandler
    public void receive(String in) {
        log.info("[X] Received '{}'", in);
    }
}
