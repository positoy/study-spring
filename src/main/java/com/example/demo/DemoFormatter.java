package com.example.demo;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class DemoFormatter implements Formatter<Demo> {

    @Override
    public Demo parse(String id, Locale locale) throws ParseException {
        return new Demo(Integer.parseInt(id));
    }

    @Override
    public String print(Demo demo, Locale locale) {
        return String.valueOf(demo.getId());
    }
}
