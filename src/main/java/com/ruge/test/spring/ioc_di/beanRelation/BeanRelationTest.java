package com.ruge.test.spring.ioc_di.beanRelation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-05  7:47
 * 描述 ：bean之间的关系 测试
 */
public class BeanRelationTest {
    /**
     * bean之间的关系-继承
     * 使用的都是继承的属性
     */
    @Test
    public void beanRelationByExtends1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/beanRelation/BeanRelation.xml");
        Object bean = context.getBean("beanRelationByExtends1");
        System.out.println(bean);
    }

    /**
     * bean之间的关系-继承
     * 部分继承 部分自己
     */
    @Test
    public void beanRelationByExtends2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/beanRelation/BeanRelation.xml");
        Object bean = context.getBean("beanRelationByExtends2");
        System.out.println(bean);

    }

    /**
     * bean之间的关系 依赖
     */
    @Test
    public void beanRelationByDepends() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/beanRelation/BeanRelation.xml");
        Object bean = context.getBean("beanRelationByDepends");
        System.out.println(bean);

    }

    /**
     * bean之间的关系-引用
     */
    @Test
    public void beanRelationByImport(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/beanRelation/BeanRelation.xml");
        Object bean = context.getBean("beanRelationByImport");
        System.out.println(bean);
    }

    /**
     * 引用外部文件
     */
    @Test
    public void dataSource() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:test/spring/ioc_di/beanRelation/BeanRelation.xml");
        DataSource source = (DataSource) context.getBean("dataSource");
        System.out.println(source.getConnection());
    }


}
