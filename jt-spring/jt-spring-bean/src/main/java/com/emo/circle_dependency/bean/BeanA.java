package com.emo.circle_dependency.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sherxia92
 * 2022/9/1 0001 下午 13:55
 */
@Component
public class BeanA {

    @Autowired
    private BeanB beanB;
}
