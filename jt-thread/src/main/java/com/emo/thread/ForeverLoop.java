package com.emo.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sherxia92
 */
@Slf4j
public class ForeverLoop {

    static boolean stop = false;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stop = true;
            log.debug("{} , modify stop to true...", Thread.currentThread().getName());
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("{} , stop is {}", Thread.currentThread().getName(), stop);
        }).start();

//        new MyThread().run();

        foo();
    }

    private static void foo() {
        int i = 0;
        while(!stop) {
            i++;
        }
        log.debug("stopped..... c: {}", i);

    }

    @Slf4j
    static class MyThread implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("{}, stop is {}", Thread.currentThread().getName(), stop);
        }
    }
}
