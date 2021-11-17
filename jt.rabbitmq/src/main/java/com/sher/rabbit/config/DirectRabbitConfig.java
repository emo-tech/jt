package com.sher.rabbit.config;

import com.sher.rabbit.work.DirectReceiver;
import com.sher.rabbit.work.DirectSender;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: sher xia
 * @create: 2021-11-17 10:42
 */
@Configuration
public class DirectRabbitConfig {

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("exchange.direct");
    }

    @Bean
    public Queue directQueue1() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue directQueue2() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding directBinding1a(DirectExchange directExchange, Queue directQueue1) {
        return BindingBuilder.bind(directQueue1).to(directExchange).with("orange");
    }

    @Bean
    public Binding directBinding1b(DirectExchange directExchange, Queue directQueue1) {
        return BindingBuilder.bind(directQueue1).to(directExchange).with("black");
    }

    @Bean
    public Binding directBinding2a(DirectExchange directExchange, Queue directQueue2) {
        return BindingBuilder.bind(directQueue2).to(directExchange).with("green");
    }

    @Bean
    public Binding directBinding2b(DirectExchange directExchange, Queue directQueue2) {
        return BindingBuilder.bind(directQueue2).to(directExchange).with("black");
    }

    @Bean
    public DirectReceiver directReceiver() {
        return new DirectReceiver();
    }

    @Bean
    public DirectSender directSender() {
        return new DirectSender();
    }
}
