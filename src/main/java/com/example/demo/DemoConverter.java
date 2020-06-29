package com.example.demo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class DemoConverter {

    @Component
    public static class DemoToString implements Converter<Demo, String> {
        @Override
        public String convert(Demo demo) {
            return String.valueOf(demo.getId());
        }
    }

    @Component
    public static class StringToDemo implements Converter<String, Demo> {
        @Override
        public Demo convert(String id) {
            return new Demo(Integer.parseInt(id));
        }
    }
}
