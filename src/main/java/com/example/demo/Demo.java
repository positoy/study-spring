package com.example.demo;

public class Demo implements Cloneable {
    int id;
    String data;

    public Demo(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    @Override
    protected Demo clone() throws CloneNotSupportedException {
        return (Demo)super.clone();
    }
}
