package com.sher.annotation.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author sherxia92
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.sher.annotation.aop")
public class AopConfig {


}
