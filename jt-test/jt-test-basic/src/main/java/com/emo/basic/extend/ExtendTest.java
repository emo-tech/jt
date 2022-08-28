package com.emo.basic.extend;

/**
 * @author sherxia92
 */
public class ExtendTest {

    public void test() {
        A a0 = new A();
        A a1 = new B();
        A a2 = new C();
    }

    public static void main(String[] args) {
        ExtendTest test = new ExtendTest();
        test.test();
    }

    class A {

    }

    class B extends A {

    }

    class C extends B {

    }
}


