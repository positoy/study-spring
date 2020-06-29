package com.example.demo;

import java.beans.PropertyEditorSupport;

public class DemoPropertyEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        Demo demo = (Demo)getValue();
        return String.valueOf(demo.getId());
    }

    @Override
    public void setAsText(String id) throws IllegalArgumentException {
        setValue(new Demo(Integer.parseInt(id)));
    }
}
