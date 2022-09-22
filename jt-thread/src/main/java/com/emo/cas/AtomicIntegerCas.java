package com.emo.cas;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sherxia92
 * 2022/9/16 0016 下午 12:19
 */
@Slf4j
public class AtomicIntegerCas {
    private static int num = 1;
    private static int times = 1000000;
    private static Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
    private AtomicInteger atomNum = new AtomicInteger(num);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (num < times) {
                        num = num + 1;
                        if (!map.containsKey(num))  {
                            map.put(num, 1);
                        } else {
                            map.put(num, map.get(num) + 1);
                        }
                        log.debug("thread: {}, num: {}", Thread.currentThread().getName(), num);
                    }
                }
            });
            thread.start();
        }
        Thread.sleep(10000);
        log.debug("map.value: {}", map.values());
        Collection<Integer> keySet = map.keySet();
        keySet.forEach(key -> {
            if (map.get(key) > 1) {
                log.debug("key: {}, value: {}", key, map.get(key));
            }
        });
    }
}
