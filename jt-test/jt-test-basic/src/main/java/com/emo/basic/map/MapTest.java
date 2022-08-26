package com.emo.basic.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MapTest {

    @Test
    public void test01() throws Exception {
        Map<String, String> map1 = new HashMap<>(3);

        Map<String, String> map = new HashMap<>(3);
        map.put("Hello", "World");

        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity:"+capacity.invoke(map));

        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size : "+size.get(map));

    }
}
