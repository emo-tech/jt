package com.emo.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sherxia92
 */
@Slf4j
public class AtomicIntegerDemo implements Runnable {
    private static final AtomicInteger atomicInteger = new AtomicInteger();

    /**
     * 增加指定数量
     */
    public void getAndAdd() {
        atomicInteger.getAndAdd(-90);
    }

    public void getAndIncrement() {
        atomicInteger.getAndIncrement();
    }

    private void getAndDecrement() {
        atomicInteger.getAndDecrement();
    }

    @Override
    public void run() {
        int times = 1000;
        for (int i = 0; i < times; i++) {
            getAndDecrement();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerDemo demo = new AtomicIntegerDemo();
        Thread t1 = new Thread(demo);
        t1.start();
        t1.join();
        log.debug("AtomicInteger操作结果：{}", atomicInteger.get());
    }
}
