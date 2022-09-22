package com.emo.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author sherxia92
 * 2022/9/16 0016 上午 11:44
 */
@Slf4j
public class ThreadCountSyncTest {

    public static void main(String[] args) {
        ThreadCountSync sync = new ThreadCountSync();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sync.test();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sync.test();
            }
        }, "t2");

//        t1.start();
//        t2.start();

        t1.run();
        t2.run();

        AbstractQueuedSynchronizer sync1 = new AbstractQueuedSynchronizer() { };
    }
}
