package com.ruge.test.spring.ioc_di.beanRange;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-05  10:54
 * 描述 ：bean的作用范围
 */
public class BeanRangeTest {
    @Test
    public void BeanRangeTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/beanRange/BeanRange.xml");
        Object bean = context.getBean("beanRange");
        Object bean2 = context.getBean("beanRange");
        System.out.println(bean == bean2);
    }
}
