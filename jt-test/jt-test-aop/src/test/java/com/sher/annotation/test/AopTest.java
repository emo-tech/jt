package com.sher.annotation.test;

import com.sher.annotation.aop.AopConfig;
import com.sher.annotation.aop.MathService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Base64Utils;
import org.springframework.util.DigestUtils;

@Slf4j
public class AopTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        log.debug("bean定义个数: [{}]", configApplicationContext.getBeanDefinitionCount());

        String[] beanNames = configApplicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            log.debug("bean名称: [{}]", beanName);
        }

        MathService mathService = configApplicationContext.getBean(MathService.class);
        mathService.add(1,2);

        configApplicationContext.close();
    }

    @Test
    public void test1() {
        String sign = DigestUtils(new String(Base64Utils.encode("da28407e-197e-4e9d-9895-8b27f12f8210222.71.36.2029vu03y+nCMlzWMcAYrTJv4KhYYX9RoiunZc8oUxgzO0哈哈哈555329141660121073706005bc97e45f6bac1f29ccbad0b956,base64Str的值为:ZGEyODQwN2UtMTk3ZS00ZTlkLTk4OTUtOGIyN2YxMmY4MjEwMjIyLjcxLjM2LjIwMjl2dTAzeStuQ01seldNY0FZclRKdjRLaFlZWDlSb2l1blpjOG9VeGd6TzDlk4jlk4jlk4g1NTUzMjkxNDE2NjAxMjEwNzM3MDYwMDViYzk3ZTQ1ZjZiYWMxZjI5Y2NiYWQwYjk1Ng==".getBytes("UTF-8")))); // MD5
        System.out.println(sign);
    }
}
