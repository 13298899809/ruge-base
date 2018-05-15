package com.ruge.test.spring.ioc_di.DI.constructorDI;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-04  20:56
 * 描述 ：构造函数注入
 */
public class ConstructorDITest {
    @Test
    public void contextByType() {
        ClassPathXmlApplicationContext contextByType = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/DI/ConstructorDI.xml");
        Object constructorDIByType = contextByType.getBean("constructorDIByType");
        System.out.println(constructorDIByType);
    }

    @Test
    public void contextByIndex() {
        ClassPathXmlApplicationContext contextByIndex = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/DI/ConstructorDI.xml");
        Object constructorDIByIndex = contextByIndex.getBean("constructorDIByIndex");
        System.out.println(constructorDIByIndex);
    }

    @Test
    public void contextByUnion() {
        ClassPathXmlApplicationContext contextByUnion = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/DI/ConstructorDI.xml");
        Object constructorDIByUnion = contextByUnion.getBean("constructorDIByUnion");
        System.out.println(constructorDIByUnion);
    }

}
