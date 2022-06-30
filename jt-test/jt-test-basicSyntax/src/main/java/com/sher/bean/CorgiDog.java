package com.sher.bean;

/**
 * @author sherxia92
 */
public class CorgiDog extends Dog {

    @Override
    public String sayName() {
        return super.sayName() + " and is corgi dog";
    }
}
