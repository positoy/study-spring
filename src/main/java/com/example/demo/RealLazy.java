package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class RealLazy {

    @PerfLogging
    public void beLazy() {
        System.out.println("Actually doing nothing...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @PerfLogging
    public void playAround() {
        System.out.println("Playing around...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
