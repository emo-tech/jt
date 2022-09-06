package com.emo.redis.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sherxia92
 * 2022/9/5 0005 下午 13:44
 */
@Slf4j
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private Redisson redisson;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/decrement01")
    public String decrement01() {
        String lockKey = "product_100";
        String redisKey = "stock";
        RLock redisLock = redisson.getLock(lockKey);
        try {
            // 加锁并设置超时时长
            redisLock.lock();
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get(redisKey));
        } finally {
            redisLock.unlock();
        }
       return "end";
    }
}
