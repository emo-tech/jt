package com.sher.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author sherxia
 */
@Slf4j
public class ForIteratorTest {


    @Test
    public void testForReturn() {
        log.debug("return value: [{}]", forReturn());
    }

    private String forReturn() {
        for (int i = 0; i < 10; i++) {
            log.debug("current i: [{}]", i);
            if (i == 5) {
                return "internal value";
            }

        }
        return "end value";
    }
}
