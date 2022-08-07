package com.emo.basic.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author sherxia92
 * 1. Arrays.asList 得到的List不能使用 add方法 （fixed-size list）
 */
@Slf4j
public class ArraysTest {

    @Test
    public void test01() {
        List<String> list = Arrays.asList("1", "2", "3");
        log.debug("{}", list);
        list.set(2, "22");
        list.add("4");

        for (String item: list) {
            log.debug("{}", item);
        }
    }

    @Test
    public void test02() {


    }

}
