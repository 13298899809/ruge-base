package com.ruge.test.spring.ioc_di.methodInto;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-04  23:30
 * 描述 ：
 */
public class MethodDITest {
    @Test
    public void theSame(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/methodInto/MethodInto.xml");
        System.out.println(context.getBean("methodDI")==context.getBean("methodDI"));
        MethodInto methodDI = (MethodInto) context.getBean("methodDI");
        System.out.println(methodDI.getDog()==methodDI.getDog());
    }
    /*Spring默认的为所有的bean设置为单例模式，只有当我们特别声明bean的模式时，Spring才会修改对应的bean设置，
    即使存在嵌套关系bean中，外层声明为prototype，其内部在未声明的情况下，仍然是单例的。*/
    @Test
    public void theDisaffinity(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/methodInto/MethodInto.xml");
        MethodInto methodDI = (MethodInto) context.getBean("methodDIByDisaffinity");
        System.out.println(context.getBean("methodDIByDisaffinity")==context.getBean("methodDIByDisaffinity"));
        System.out.println(methodDI.getDog()==methodDI.getDog());
    }
}
