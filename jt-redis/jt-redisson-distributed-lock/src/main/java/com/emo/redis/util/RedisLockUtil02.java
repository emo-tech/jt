package com.emo.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author sherxia92
 */
@Component
public class RedisLockUtil02 {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * lua解锁脚本
     */
    public void unlock(String lockKey, String requestId) {
        // 解锁脚本
        DefaultRedisScript<Object> unlockScript = new DefaultRedisScript<>();
        unlockScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lockDel.lua")));

        // 执行lua脚本并解锁
        redisTemplate.execute(unlockScript, Collections.singletonList(lockKey), requestId);
    }
}
