package com.emo.rabbitmq.config;

import com.emo.rabbitmq.work.SimpleReceiver;
import com.emo.rabbitmq.work.SimpleSender;
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
