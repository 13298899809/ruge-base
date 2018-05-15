package com.ruge.test.spring.aop;

import com.ruge.test.spring.aop.proxy.MathProxy;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-06  7:20
 * 描述 ：日志的实现
 */
public class AdviceTest {

    /**
     * 基于动态代理实现的日志的信息
     */
    @Test
    public void ProxyAdviceTest(){
        IMathService service = new MathServiceImpl();
        IMathService proxy =  new MathProxy(service).getLoggerProxy();
        proxy.add(2,3);
    }

    /**
     * 基于注解方式实现的日志信息
     */
    @Test
    public void AnnotationAdviceTest(){
        /**
         * 1 创建spring 的ioc 容器
         */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/aop/AnnotationAdvice.xml");
        /**
         * 2 从ioc容器中获取bean
         */
        IMathService bean = (IMathService) context.getBean("mathServiceImpl");
        int i = 0;
        try {
            /**
             * 前置通知
             */
            i = bean.div(3, 1);
            /**
             * 返回通知 可以获取方法的返回值
             */
        } catch (Exception e) {
            /**
             * 异常通知  可以访问到方法的异常
             */
        }
        /**
         * 后置通知  因为方法可能异常  可能访问不到
         */
        System.out.println(i);
    }

    /**
     * 基于 xml配置的方式实现日志
     */
    @Test
    public void XmlAdviceTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/aop/XmlAdvice.xml");
        IMathService bean = (IMathService) context.getBean("mathServer");
        int i = 0;
        try {
            i = bean.div(3, 1);
        } catch (Exception e) {
        }
        System.out.println(i);
    }


}
