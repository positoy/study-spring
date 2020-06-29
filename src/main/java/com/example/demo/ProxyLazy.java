package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ProxyLazy implements BeingLazy {
    @Autowired
    RealLazy realLazy;

    @Override
    public void beLazy() {
        long begin = System.currentTimeMillis();
        realLazy.beLazy();
        System.out.println("consumed time : " + (System.currentTimeMillis() - begin));
    }

    @Override
    public void playAround() {
        long begin = System.currentTimeMillis();
        realLazy.playAround();
        System.out.println("consumed time : " + (System.currentTimeMillis() - begin));
    }
}
