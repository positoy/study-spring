package com.example.demo;

import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class Webconfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DemoConverter.DemoToString());
        registry.addConverter(new DemoConverter.StringToDemo());
    }
}
