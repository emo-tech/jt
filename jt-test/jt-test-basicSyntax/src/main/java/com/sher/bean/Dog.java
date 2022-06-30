package com.sher.bean;

/**
 * @author sherxia92
 */
public class Dog implements Animal {

    @Override
    public String sayHello() {
        return "hello dog";
    }

    protected String sayName() {
        return "my name is dog";
    }
}
