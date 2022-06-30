package com.sher.test;

import com.sher.bean.CorgiDog;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class OverrideTest {

    @Test
    public void test(){
        CorgiDog dog = new CorgiDog();
        log.debug(dog.sayHello());
        log.debug(dog.sayName());
    }
}