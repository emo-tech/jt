package com.emo.basic.map;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sherxia92
 */
@Slf4j
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("name", "sher");

        String key = "age";
        log.debug("{}", concurrentHashMap.get(key));
        log.debug("{}", concurrentHashMap.contains(key));
        log.debug("{}", concurrentHashMap.containsKey(key));
    }
}
