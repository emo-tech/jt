package com.emo.thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @author sherxia92
 * 2022/9/14 0014 下午 21:45
 */
@Slf4j
public class MainAfterSubThread01_CountDownLatch {

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(3);
        LatchDemo latchDemo = new LatchDemo(countDownLatch);
        for (int i = 1; i <= 3; i++) {
            new Thread(latchDemo, "t" + i).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            log.error("", e);
        }
        log.info("主线程执行...");
    }

    static class LatchDemo implements Runnable {
        // 多线程共享latch
        private CountDownLatch countDownLatch;

        public LatchDemo(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @SneakyThrows
        @Override
        public void run() {
            log.debug("{} 执行开始", Thread.currentThread().getName());
            Thread.sleep(1000);
            countDownLatch.countDown();
            log.debug("{} 执行结束", Thread.currentThread().getName());
        }
    }
}
