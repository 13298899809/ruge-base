package com.ruge.test.spring.ioc_di.DI.factoryDI;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-04  21:15
 * 描述 ： 工厂方式注入 测试
 */
public class FactoryDITest {
    @Test
    public void context(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/DI/FactoryDI.xml");
        Object di = context.getBean("factoryDI");
        System.out.println(di);
    }

    @Test
    public void staticContext(){
        ClassPathXmlApplicationContext staticContext = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/DI/FactoryDI.xml");
        Object staticDi = staticContext.getBean("staticFactoryDI");
        System.out.println(staticDi);
    }
}
