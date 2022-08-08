package com.emo.jvm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author sherxia92
 */
@Slf4j
public class OutOfMemoryTest {

    @Test
    public void test01() throws InterruptedException {
        List<Staff> staffList = new ArrayList<>();
        Random random = new Random();
        while(true){
            staffList.add(new Staff(random.nextInt(Integer.MAX_VALUE), "free"));
        }
    }

    @Test
    public void test02() {
        Random random = new Random();
        log.debug("{}", random.nextInt(1000));
    }

    @Data
    @AllArgsConstructor
    class Staff {
        private int id;
        private String name;
    }
}
