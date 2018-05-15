package com.ruge.test.spring.ioc_di.DI.genericDI;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-05  23:30
 * 描述 ：泛型依赖注入 测试
 */
public class GenericDIRepositoryTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/DI/GenericDI.xml");
        GenericDIRepository bean = (GenericDIRepository) context.getBean("genericDIRepository");
        bean.add();
    }
}
