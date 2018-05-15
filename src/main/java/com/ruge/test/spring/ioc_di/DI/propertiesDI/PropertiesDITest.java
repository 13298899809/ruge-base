package com.ruge.test.spring.ioc_di.DI.propertiesDI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.junit.Test;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-04  20:50
 * 描述 ： 属性注入测试
 */
public class PropertiesDITest {
    /**
     * 基本类型
     */
    @Test
    public void context() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/DI/PropertiesDI.xml");
        Object di = context.getBean("propertiesDI");
        System.out.println(di);
    }
    /**
     * 注入bean
     */
    @Test
    public void contextByBean() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/DI/PropertiesDI.xml");
        Object diByBean = context.getBean("propertiesDIByBean");
        System.out.println(diByBean);
    }

    /**
     * 内部bean
     */
    @Test
    public void contextByPrivateBean() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/DI/PropertiesDI.xml");
        Object di = context.getBean("propertiesDIByPrivateBean");
        System.out.println(di);
    }

    /**
     * null值
     */
    @Test
    public void contextByNullBean() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/DI/PropertiesDI.xml");
        Object di = context.getBean("propertiesDIByNullBean");
        System.out.println(di);
    }

    /**
     * 级联属性
     */
    @Test
    public void propertiesDIByCascadingBean() {
        ClassPathXmlApplicationContext context111 = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/DI/PropertiesDI.xml");
        Object di = context111.getBean("propertiesDIByCascadingBean");
        System.out.println(di);
    }

    /**
     * 集合类型属性
     */
    @Test
    public void propertiesDIByCollectionBean() {
        ClassPathXmlApplicationContext context111 = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/DI/PropertiesDI.xml");
        Object di = context111.getBean("propertiesDIByCollectionBean");
        System.out.println(di);
    }

    /**
     * 引用外部集合
     */
    @Test
    public void propertiesDIByOutSideCollectionBean() {
        ClassPathXmlApplicationContext context111 = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/DI/PropertiesDI.xml");
        Object di = context111.getBean("propertiesDIByOutSideCollectionBean");
        System.out.println(di);
    }

    /**
     * 通过P标签为属性赋值
     */
    @Test
    public void propertiesDIByP() {
        ClassPathXmlApplicationContext context111 = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/DI/PropertiesDI.xml");
        Object di = context111.getBean("propertiesDIByP");
        System.out.println(di);
    }

}
