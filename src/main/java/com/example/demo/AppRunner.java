package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    final static Logger logger = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    BeingLazy beingLazy;

    public void doProxyTest() {
        beingLazy.beLazy();
        beingLazy.playAround();
    }

    @Value("#{1}")
    Integer i;

    @Value("#{1-2}")
    Integer iminus;

    @Value("#{true}")
    Boolean b;

    @Value("#{1 eq 1}")
    Boolean bEqual;

    @Value("#{'hello'}")
    String hello;

    @Value("#{'world'}")
    String world;

    @Value("#{'hello' + 'world'}")
    String helloWorld;

    @Value("${my.value}")
    String myvalue;

    @Value("#{${my.value} eq 100}")
    Boolean myValueEq;

    @Value("#{sample.data}")
    Integer sampleData;

    public void doSpringExpressionLanguageTest() {
        System.out.println(i);
        System.out.println(iminus);
        System.out.println(b);
        System.out.println(bEqual);

        System.out.println(hello);
        System.out.println(world);
        System.out.println(helloWorld);

        System.out.println(myvalue);
        System.out.println(myValueEq);
        System.out.println(sampleData);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        doProxyTest();
        doSpringExpressionLanguageTest();
    }
}
