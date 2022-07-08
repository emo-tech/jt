package com.sher.test.annotation;

import com.sher.test.annotation.importSelector_test.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class ImportSelectorTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        applicationContext.start();
        log.debug("bean count: [{}]", applicationContext.getBeanDefinitionCount());
    }
}
