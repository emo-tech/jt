package com.sher.annotation.test;

import com.sher.annotation.aop.AopConfig;
import com.sher.annotation.aop.MathService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class AopTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        log.debug("bean定义个数: [{}]", configApplicationContext.getBeanDefinitionCount());

        MathService mathService = configApplicationContext.getBean(MathService.class);
        mathService.add(1,2);

        configApplicationContext.close();
    }
}
