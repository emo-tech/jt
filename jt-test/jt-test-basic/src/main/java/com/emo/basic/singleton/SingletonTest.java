package com.emo.basic.singleton;

/**
 * @author sherxia92
 */
public class SingletonTest {

    public static void main(String[] args) {

        SingletonEnum.INSTANCE.doSomething();

        SingletonStaticInner.getInstance().doSomething();

        SingletonDcl.getInstance().doSomething();
    }
}
