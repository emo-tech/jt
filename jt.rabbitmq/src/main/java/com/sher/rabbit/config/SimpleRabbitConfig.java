package com.sher.rabbit.config;

import com.sher.rabbit.work.SimpleReceiver;
import com.sher.rabbit.work.SimpleSender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: sher xia
 * @create: 2021-11-12 16:18
 */
@Configuration
public class SimpleRabbitConfig {

    @Bean
    public Queue simpleQueue() {
        return new Queue("simple.hello");
    }

    @Bean
    public SimpleSender simpleSender() {
        return new SimpleSender();
    }

    @Bean
    public SimpleReceiver simpleReceiver() {
        return new SimpleReceiver();
    }

}
