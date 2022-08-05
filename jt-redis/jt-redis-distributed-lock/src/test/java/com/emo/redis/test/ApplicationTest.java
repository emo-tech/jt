package com.emo.redis.test;

import com.emo.redis.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Slf4j
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    @Autowired
    public RedisTemplate redisTemplate;

    @Test
    public void addData() {
        redisTemplate.opsForValue().setIfAbsent("name", "sher", 30, TimeUnit.SECONDS);
    }
}
