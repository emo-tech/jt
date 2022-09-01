package com.emo.basic.map;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * @author sherxia92
 */
@Slf4j
public class HashMapTest {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("key1", null);

        log.debug("{}", hashMap.get("key1"));
        log.debug("{}", hashMap.get("key2"));
        log.debug("{}", hashMap.containsKey("key2"));
    }
}
