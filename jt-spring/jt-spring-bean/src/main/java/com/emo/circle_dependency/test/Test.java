package com.emo.circle_dependency.test;

import com.emo.circle_dependency.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author sherxia92
 * 2022/9/1 0001 下午 14:04
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        applicationContext.start();
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        for (int i = 0; i < beanDefinitionNames.length; i++) {
            log.debug("beanDefinitionNames: [{}] --- [{}]", i, beanDefinitionNames[i]);
        }
        applicationContext.close();
    }
}
