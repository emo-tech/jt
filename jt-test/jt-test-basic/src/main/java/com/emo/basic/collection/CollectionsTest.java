package com.emo.basic.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sherxia92
 * 2022/9/6 0006 下午 14:14
 */
public class CollectionsTest {

    public static void main(String[] args) {
        // 旧的遗留
        Vector<String> vector = new Vector<String>();
        Hashtable<String, Object> hashTable = new Hashtable();

        // collections类下的  线程安全
        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<String>());

        // concurrent开头的集合类
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap();
    }
}
