package com.example.demo;

import java.lang.annotation.*;

/**
 * This Annotation helps logging the time consumed for method execution.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface PerfLogging {
}
