package com.emo.lock;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sherxia92
 * 2022/8/8 0008 下午 15:07
 * wati/notify实现不可重入锁
 */
@Slf4j
public class NonReentrantLockDemo1 {
    /**
     * 记录是否被锁
     */
    private volatile boolean locked = false;

    /**
     * 加锁
     */
    public synchronized void lock() {
        while (locked) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("", e);
            }
        }
        // 枷锁成功， locked设置为true
        locked = true;
    }

    /**
     * 释放锁
     */
    public synchronized void unlock() {
        locked = false;
        notify();
    }
}
