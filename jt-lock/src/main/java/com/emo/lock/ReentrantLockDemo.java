package com.emo.lock;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sherxia92
 */
@Slf4j
public class ReentrantLockDemo {
    static final MyReentrantLock LOCK = new MyReentrantLock(true);
    static Condition c1 = LOCK.newCondition("c1");
    static Condition c2 = LOCK.newCondition("c2");

    public static void main(String[] args) throws InterruptedException {
//        learnLock();
        fairVsUnfair();
    }


    private static void learnLock() throws InterruptedException {
        log.debug("lock: [{}]", LOCK);
        new MyThread(() -> {
            LOCK.lock();
            log.debug("t1 acquire lock ...");
            LOCK.toString();
            LOCK.unlock();
            LOCK.toString();
        }, "t1").start();

        Thread.sleep(100);

        new MyThread(() -> {
            LOCK.lock();
            log.debug("t2 acquire lock ...");
            LOCK.toString();
            LOCK.unlock();
            LOCK.toString();
        }, "t2").start();

        Thread.sleep(100);

        new MyThread(() -> {
            LOCK.lock();
            LOCK.lock();
            log.debug("t3 acquire lock ...");
            LOCK.toString();

            try {
                Thread.sleep(25000);
                LOCK.toString();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t3").start();

        log.debug("main thread start......");
        Thread.sleep(20000);
        log.debug("main thread end......");
        log.debug("main thread lock tostring ......");
        LOCK.toString();
    }

    public static void fairVsUnfair() throws InterruptedException {
        new MyThread(() -> {
            LOCK.lock();
            log.debug("{} acquire lock....", Thread.currentThread().getName());
            LOCK.toString();
            sleep1s();
            LOCK.unlock();
        }, "t1").start();

        Thread.sleep(100);
        new MyThread(() -> {
            LOCK.lock();
            log.debug("{} acquire lock....", Thread.currentThread().getName());
            LOCK.toString();
            sleep1s();
            LOCK.unlock();
        }, "t2").start();

        Thread.sleep(100);
        new MyThread(() -> {
            LOCK.lock();
            log.debug("{} acquire lock....", Thread.currentThread().getName());
            LOCK.toString();
            sleep1s();
            LOCK.unlock();
        }, "t3").start();

        Thread.sleep(100);
        new MyThread(() -> {
            LOCK.lock();
            log.debug("{} acquire lock....", Thread.currentThread().getName());
            LOCK.toString();
            sleep1s();
            LOCK.unlock();
        }, "t4").start();
    }


    private static void sleep1s() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyReentrantLock extends ReentrantLock {
        private final Map<String, Condition> conditions = new HashMap<>();

        MyReentrantLock(boolean fair) {
            super(fair);
        }

        public Condition newCondition(String name) {
            Condition condition = super.newCondition();
            conditions.put(name, condition);
            return condition;
        }

        @Override
        public String toString() {
            StringBuffer stringBuilder = new StringBuffer(512);
            String queuedInfo = getQueuedInfo();

            this.getOwner();
            System.out.println("");
            System.out.println("---------------------------------------------------");
            System.out.println("| owner: " + this.getOwner());
            System.out.println("| holdCount: " + this.getHoldCount());
            System.out.println("| queue.length: " + this.getQueueLength());
            System.out.println("| queue.threads:" + this.getQueuedThreads());
            System.out.println("| c1.waiting.threads:" + this.getWaitingThreads(c1));
            System.out.println("| c2.waiting.threads:" + this.getWaitingThreads(c2));
            System.out.println("| c1.waiting.queue.length:" + this.getWaitQueueLength(c1));
            System.out.println("| c2.waiting.queue.length:" + this.getWaitQueueLength(c2));
            System.out.println("---------------------------------------------------");
            System.out.println("");
            return "";
//            return "MyReentrantLock{" + "\\r\\n" +
//                    "owner=" + this.getOwner() +
//                    "queue.length=" + this.getQueueLength() +
//                    "queue.threads=" + this.getQueuedThreads() +
//                    "waiting.threads=" + this.getWaitingThreads(null) +
//                    "waiting.queue.length=" + this.getWaitQueueLength(null) +
//                    '}';
        }

        private String getQueuedInfo() {
            List<String> result = new ArrayList<>();
            try {
                Field firstWaiterField = AbstractQueuedSynchronizer.ConditionObject.class.getDeclaredField("firstWaiter");

            } catch (Exception e) {
                e.printStackTrace();
            }
            return String.join("->", result);
        }

    }


    static class MyThread extends Thread {

        public MyThread(Runnable target, String name) {
            super(target, name);
        }

        @Override
        public String toString() {
            return this.getName();
        }
    }
}
