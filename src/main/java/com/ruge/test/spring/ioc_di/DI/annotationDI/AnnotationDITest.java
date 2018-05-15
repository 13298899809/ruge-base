package com.ruge.test.spring.ioc_di.DI.annotationDI;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-05  22:04
 * 描述 ：通过注解方式配置bean 测试
 */
public class AnnotationDITest {
    @Test
    public void AnnotationDIControllerTest() {
        ClassPathXmlApplicationContext contextByIndex = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/DI/AnnotationDI.xml");
        AnnotationController constructorDIByIndex = (AnnotationController) contextByIndex.getBean("annotationController");
        constructorDIByIndex.exec();
        System.out.println(constructorDIByIndex);
    }

    @Test
    public void AnnotationDIServiceTest() {
        ClassPathXmlApplicationContext contextByIndex = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/DI/AnnotationDI.xml");
        Object constructorDIByIndex = contextByIndex.getBean("annotationService");
        System.out.println(constructorDIByIndex);
    }
}
