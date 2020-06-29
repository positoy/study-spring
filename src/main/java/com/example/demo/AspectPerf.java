package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectPerf {

    @Around("execution(* com.example.demo.RealLazy.*())")
    public Object perfLogger(ProceedingJoinPoint pjp) throws Throwable{
        long begin = System.currentTimeMillis();
        Object ret = pjp.proceed();
        System.out.println("consumed time : " + (System.currentTimeMillis() - begin));
        return ret;
    }
}
