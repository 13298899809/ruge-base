package com.ruge.test.spring.ioc_di.methodReplace;

import lombok.Data;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-04  23:52
 * 描述 ：方法替换1
 */
@Data
public class MethodReplace1 {
    private int id;
    private String name;
    private int age;
    private  Dog dog;
    public  Dog getDog() {
         Dog dog = new Dog();
        dog.setName("11111");
        return dog;
    }

}
