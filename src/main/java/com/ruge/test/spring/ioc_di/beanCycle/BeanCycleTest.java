package com.ruge.test.spring.ioc_di.beanCycle;

import lombok.Data;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-05  20:33
 * 描述 ：bean的生命周期 测试
 */

public class BeanCycleTest {
   @Test
   public static void main(String[] args) {
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/beanCycle/BeanCycle.xml");
       Object bean = context.getBean("beanCycle");
       System.out.println(bean);
       context.close();
   }
}
