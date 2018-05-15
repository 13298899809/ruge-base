package com.ruge.test.spring.ioc_di.beanCycle;

import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-05  21:33
 * 描述 ：bean 的后置处理器
 */
public class BeanCyclePeocress implements BeanPostProcessor {

    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("After BeanCycle"+bean+","+beanName);
        if("***".equals(beanName)){
            // 巴拉巴拉业务操作
        }
        return bean;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("Before BeanCycle"+bean+","+beanName);
        return bean;
    }
}
