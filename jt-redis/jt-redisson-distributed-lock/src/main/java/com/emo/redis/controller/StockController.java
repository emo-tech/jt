package com.emo.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sherxia92
 * 2022/9/5 0005 下午 13:44
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
}
