package com.ruge.test.spring.ioc_di.methodReplace;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-04  23:52
 * 描述 ：方法替换2
 */
public class MethodReplace2 implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
         Dog dog = new Dog();
        dog.setName("22222");
        return dog;
    }
}
