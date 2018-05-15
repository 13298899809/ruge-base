package com.ruge.test.spring.helloWorld;

import lombok.Data;
import lombok.extern.java.Log;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-04  18:08
 * 描述 ：spring的第一个helloworld
 */
@Data
public class HelloWorld {
    private String name;

    public void sayHello() {
        System.out.println("hello spring"+name);
    }
}
