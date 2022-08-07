package com.emo.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author sherxia92
 */
public class RedisLock01 {

    @Autowired
    private RedisTemplate redisTemplate;

    public Boolean tryLock(String key, String value, long timeout, TimeUnit unit) {
        return redisTemplate.opsForValue().setIfAbsent(key, value, timeout, unit);
    }

    public void unlock(String lockName, String uuid) {
        if (uuid.equals(redisTemplate.opsForValue().get(lockName))) {
            redisTemplate.opsForValue().getAndDelete(lockName);
        }
    }

}
