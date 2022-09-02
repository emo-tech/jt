package com.emo.keyword;

import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sherxia92
 * 2022/8/17 0017 上午 10:00
 */
@Slf4j
@Data
public class ResortDemo {
    @Getter
    private int a = 0;
    private boolean flag = false;

    public void method1() {
        a = 1;
        flag = true;
    }

    public void method2() {
        if (flag) {
            a = a + 1;
        }
    }

    public void doMethod() {
        this.method1();
        this.method2();
    }

    public static void main(String[] args) {
        Set<Object> set = new HashSet<>();
        ResortDemo resortDemo = new ResortDemo();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    resortDemo.doMethod();
//                    set.add(resortDemo.number);
                }
            }, String.valueOf(i)).start();
        }
    }
}
