package com.emo.basic.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sherxia92
 * @Description: 延迟加载
 *               静态内部类只有在调用静态内部方法静态域或者构造方法时候  才会加载
 *               用静态内部类方法才会 实例化
 */
@Slf4j
public class SingletonStaticInner {
    private static class SingletonHolder {
        private static final SingletonStaticInner INSTANCE = new SingletonStaticInner();
    }

    private SingletonStaticInner() {}

    public static final SingletonStaticInner getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void doSomething() {
        log.debug("我是 [静态内部类] 的单例模式");
    }
}
