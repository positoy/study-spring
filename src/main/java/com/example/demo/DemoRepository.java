package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class DemoRepository {

    ArrayList<Demo> demos = new ArrayList<>();

    public DemoRepository() {
        demos.add(new Demo(0, "hello"));
        demos.add(new Demo(1, "world"));
        demos.add(new Demo(2, "hello"));
        demos.add(new Demo(3, "world"));
        demos.add(new Demo(4, "hello"));
        demos.add(new Demo(5, "world"));
    }
}
