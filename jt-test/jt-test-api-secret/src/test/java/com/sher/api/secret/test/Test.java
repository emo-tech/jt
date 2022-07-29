package com.sher.api.secret.test;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class Test {

    @org.junit.jupiter.api.Test
    public void localDateTimeTest() {
      log.debug("{}", LocalDateTime.now());
    }
}
