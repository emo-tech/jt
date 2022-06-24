package com.sher.test.annotation;

import com.sher.test.annotation.import_test.AppConfig;
import com.sher.test.annotation.common.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class ImportTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        applicationContext.start();
        User user = applicationContext.getBean(User.class);
        log.debug("user != null is: [{}]", user != null);
        applicationContext.close();
    }
}
