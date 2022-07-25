package com.sher.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @author sherxia92
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        // 让2个线程去等待三个工作线程执行完成
        CountDownLatch countDownLatch = new CountDownLatch(3);

        // 2个等待线程
        WaitThread waitThread1 = new WaitThread("wait1", countDownLatch);
        WaitThread waitThread2 = new WaitThread("wait2", countDownLatch);

        // 3个工作线程
        WorkerThread workerTread1 = new WorkerThread("work1", countDownLatch);
        WorkerThread workerTread2 = new WorkerThread("work2", countDownLatch);
        WorkerThread workerTread3 = new WorkerThread("work3", countDownLatch);

        waitThread1.start();
        waitThread2.start();
        Thread.sleep(1000);
        workerTread1.start();
        workerTread2.start();
        workerTread3.start();
    }
}

/**
 * 等待线程
 */
@Slf4j
class WaitThread extends Thread {

    private String name;
    private CountDownLatch countDownLatch;

    public WaitThread(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            log.debug("{} waiting...", this.name);
            countDownLatch.await();
            log.debug("{} continue running...", this.name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 工作线程
 */
@Slf4j
class WorkerThread extends Thread {
    private String name;
    private CountDownLatch countDownLatch;

    public WorkerThread(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        log.debug("{} is running...", this.name);
        try {
            log.debug("{} countDownLatch before sleep count {}", this.name, countDownLatch.getCount());
            Thread.sleep(2);
            log.debug("{} countDownLatch after sleep count {}", this.name, countDownLatch.getCount());
        } catch (InterruptedException e) {
            log.error("", e);
        }
        log.debug("{} is end.", this.name);
        countDownLatch.countDown();
        log.debug("{} countDownLatch after countDown count {}", this.name, countDownLatch.getCount());
    }
}