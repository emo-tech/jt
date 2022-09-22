package com.emo.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sherxia92
 * 2022/9/16 0016 上午 11:44
 */
@Slf4j
public class ThreadCountSync {
    private int num = 0;

    public void test() {
        for (int i = 0; i < 1000; i++) {
            synchronized(this) {
                log.debug("thread: {}, num: {}", Thread.currentThread().getId(), num++);
            }
        }
    }
}
