package com.sher.redis.lock.util;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author sherxia92
 */
@Slf4j
public abstract class RedisLock implements Lock {

    protected Jedis jedis;
    protected String lockKey;

    public RedisLock(Jedis jedis, String lockKey) {
        this.jedis = jedis;
        this.lockKey = lockKey;
    }

    public void sleepBySecond(int second) {
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            log.error("", e);
        }
    }

    @Override
    public void lockInterruptibly(){}

    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) {
        return false;
    }
}
