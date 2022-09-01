package com.emo.basic.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sherxia92
 */
@Slf4j
public class SingletonDcl {
    private static SingletonDcl singleton = null;

    private SingletonDcl() {}

    public static SingletonDcl getInstance() {
        if (singleton == null) {
            synchronized (SingletonDcl.class) {
                if (singleton == null) {
                    singleton = new SingletonDcl();
                }
            }
        }
        return singleton;
    }

    public void doSomething() {
        log.debug("我是 [Double check lock] 的单例模式");
    }
}
