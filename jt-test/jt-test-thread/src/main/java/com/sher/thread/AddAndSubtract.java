package com.sher.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @author sherxia92
 */
@Slf4j
public class AddAndSubtract {

    static volatile int balance = 10;

    public static void subtract() {
        int temp = balance;
        temp -= 5;
        balance = temp;
    }

    public static void add() {
        int temp = balance;
        temp += 5;
        balance = temp;
    }

    public static int doThread() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            subtract();
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            add();
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        log.debug("{}", balance);
        return balance;
    }

    public static void main(String[] args) throws InterruptedException {
        int result = doThread();
        int preResult = 0;
        do {
            preResult = result;
            result = doThread();
        } while (preResult == result);

    }
}
