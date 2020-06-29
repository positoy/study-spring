package com.example.demo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

class DemoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Demo.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data", "notempty", "data must not be empty");
        Demo demo = (Demo)target;
        if (demo.getId() < 0) {
            errors.reject("notnegative", "id must not be negative");
        }
    }
}