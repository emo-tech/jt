package com.emo.keyword;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author sherxia92
 * 2022/8/17 0017 上午 9:58
 * @description： volatile 关键字不保证原子性，可能会出现线程不安全的情况
 */
@Slf4j
@Data
public class VolatileTest02 {

    volatile int number = 0;

    public void increment(){
        this.number = this.number + 1;
    }

    public static void main(String[] args) {
        VolatileTest02 demo = new VolatileTest02();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    demo.increment();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        log.debug("Thread.currentThread().getName() = {}, result number = {}", Thread.currentThread().getName(), String.valueOf(demo.getNumber()));
    }

}
