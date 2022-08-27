package com.emo.rabbit.test.producer;

import com.emo.rabbit.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author sherxia92
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-rabbitmq-producer.xml"})
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void senQueue() {
        log.debug("================");
        log.debug("================");
        log.debug("================");
        log.debug("{}", rabbitTemplate);
        rabbitTemplate.convertAndSend(Constant.FANOUT_QUEUE1, "456");
    }


    @Test
    public void senExchange() {
        log.debug("================");
        log.debug("{}", rabbitTemplate);
        rabbitTemplate.convertAndSend(Constant.FANOUT_EXCHANGE, "", "send to fanout exchange");
        log.debug("================");
    }

}
