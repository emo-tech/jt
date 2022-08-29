package com.emo;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;

/**
 * @author sherxia92
 * 2022/8/29 0029 下午 14:14
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DruidDataSourceAutoConfigure.class,
        SecurityAutoConfiguration.class,
        SecurityFilterAutoConfiguration.class
})
public class SpringBootBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBasicApplication.class, args);
    }
}
