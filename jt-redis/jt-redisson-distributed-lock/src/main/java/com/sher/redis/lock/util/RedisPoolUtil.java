package com.sher.redis.lock.util;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * @description:
 * @author: sher xia
 * @create: 2021-06-11 11:21
 */
@Slf4j
@NoArgsConstructor
public class RedisPoolUtil {
    private static final String LOCKER_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {
        String result = null;
//                jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        if (LOCKER_SUCCESS.equals(result)) {
            return true;
        } else {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                log.error("", e);
            }
        }
        return false;
    }

    public static boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        if (LOCKER_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
}
