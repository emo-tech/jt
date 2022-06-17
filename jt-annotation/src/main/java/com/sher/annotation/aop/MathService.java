package com.sher.annotation.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author sherxia92
 */
@Slf4j
@Service
public class MathService {

    public int add(int a, int b) {
        log.debug("方法正在执行...");
        return a + b;
    }
}
