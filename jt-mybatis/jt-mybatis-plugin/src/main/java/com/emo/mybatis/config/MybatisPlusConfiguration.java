package com.emo.mybatis.config;

import com.emo.mybatis.interceptor.PrintInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sherxia92
 */
@Configuration
public class MybatisPlusConfiguration {


    @Bean
    public PrintInterceptor printInterceptor() {
        return new PrintInterceptor();
    }
}
