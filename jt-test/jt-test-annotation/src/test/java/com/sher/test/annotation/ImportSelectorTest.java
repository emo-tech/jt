package com.sher.test.annotation;

import com.sher.test.annotation.common.User;
import com.sher.test.annotation.importselector_test.AppConfig;
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
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinition: beanDefinitionNames) {
            log.debug("beanDefinition: [{}]", beanDefinition);
            log.debug("bean: [{}]", applicationContext.getBean(beanDefinition));
        }
        applicationContext.getBean(User.class);

        applicationContext.close();
    }
}
