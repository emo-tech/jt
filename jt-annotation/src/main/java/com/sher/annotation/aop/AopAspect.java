package com.sher.annotation.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author sherxia92
 */
@Slf4j
@Aspect
@Component
public class AopAspect {

    @Before("execution(* com.sher.annotation.aop.MathService.add(..))")
    public void beforeAdd() {
        log.debug("方法执行前...Before");
    }

    @Around("execution(* com.sher.annotation.aop.MathService.add(..))")
    public Object aroundAdd(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.debug("方法环绕执行...Around");
        return proceedingJoinPoint.proceed();
    }

    @After("execution(* com.sher.annotation.aop.MathService.add(..))")
    public void afterAdd() {
        log.debug("方法执行后...After");
    }
}
