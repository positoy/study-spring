package com.example.demo;

import javax.validation.constraints.*;

public class Demo implements Cloneable {
    @Min(0)
    int id;
    @NotEmpty
    String data;

    public Demo(@Min(0) int id) {
        this.id = id;
    }

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
