package com.sher.redis.lock.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

/**
 * @author sherxia92
 * description: 基础版本锁
 */
public class LockCase1 extends RedisLock {

    public LockCase1(Jedis jedis, String name) {
        super(jedis, name);
    }

    @Override
    public void lock() {
        while(true) {
            SetParams setParams = new SetParams();
            setParams.nx();
            String result = jedis.set(lockKey, "value", setParams);
        }
    }

    @Override
    public void unlock() {

    }
}
