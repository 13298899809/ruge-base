package com.ruge.test.spring.ioc_di.autoAssemble;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-05  9:03
 * 描述 ：自动配置bean
 */
public class AutoAssembleTest {

    @Test
    public void AutoAssembleTestByName(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/autoAssemble/AutoAssembleByName.xml");
        Object di = context.getBean("AutoDI");
        System.out.println(di);
    }

    @Test
    public void AutoAssembleByType(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/autoAssemble/AutoAssembleByType.xml");
        Object di = context.getBean("AutoAssembleByType");
        System.out.println(di);
    }

    @Test
    public void AutoAssembleByConstructor(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/autoAssemble/AutoAssembleByConstructor.xml");
        Object di = context.getBean("AutoConstructor");
        System.out.println(di);
    }
}
