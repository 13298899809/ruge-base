package com.ruge.test.spring.helloWorld;

import lombok.extern.java.Log;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-04  18:11
 * 描述 ：helloWorld 测试
 */
@Log
public class HelloWorldTest {
    public static void main(String[] args) {
        HelloWorld world = new HelloWorld();
        world.setName("张三");
        world.sayHello();
        /**
         * 创建spring的IOC容器
         */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/helloWorld/helloWorld.xml");
        /**
         * 从IOC容器中获取bean实例
         */
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        /**
         * 方法的调用
         */
        helloWorld.sayHello();
    }
}
