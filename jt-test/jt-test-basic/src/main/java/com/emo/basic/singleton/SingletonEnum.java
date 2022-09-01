package com.emo.basic.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sherxia92
 * @Description: 避免多线程同步问题，防止反序列化
 */
@Slf4j
public enum SingletonEnum {
    INSTANCE;

    public void doSomething() {
        log.debug("我是 [枚举] 单例模式");
    }
}
