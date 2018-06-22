package com.ruge.test.springMVC.常用注解.自定义注解;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface demo01_自定义注解 {
     String author() default "";

     String date() default "";

    String [] revire();

    String value() default "";
}
