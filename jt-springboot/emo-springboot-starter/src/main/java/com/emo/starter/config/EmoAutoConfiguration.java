package com.emo.starter.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sherxia92
 * 2022/9/9 0009 上午 8:52
 */
@Slf4j
@Configuration
public class EmoAutoConfiguration {

    @Bean
    public EmoProperties emoProperties() {
        log.info("emo properties be created...");
        return new EmoProperties();
    }
}
