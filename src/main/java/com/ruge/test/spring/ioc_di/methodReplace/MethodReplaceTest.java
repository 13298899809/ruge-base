package com.ruge.test.spring.ioc_di.methodReplace;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-04  23:52
 * 描述 ：方法替换 测试
 */
public class MethodReplaceTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/methodReplace/MethodReplace.xml");
          MethodReplace1 methodReplace = (MethodReplace1) context.getBean("methodReplace");
        System.out.println(methodReplace);
    }
}
