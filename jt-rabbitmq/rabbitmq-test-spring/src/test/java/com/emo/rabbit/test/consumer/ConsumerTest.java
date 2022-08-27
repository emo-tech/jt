package com.emo.rabbit.test.consumer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author sherxia92
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-rabbitmq-consumer.xml"})
public class ConsumerTest {

    @Test
    public void consumer01() {
        while (true) {

        }
    }
}
