package com.emo.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sherxia92
 */
public class Test {
    static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        System.out.println("123");
        logger.info("hello slf4j");
    }
}
