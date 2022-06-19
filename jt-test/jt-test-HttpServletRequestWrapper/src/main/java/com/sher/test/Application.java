package com.sher.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author sherxia92
 */
@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class,
//        SecurityDataConfiguration.class
})
@ServletComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
