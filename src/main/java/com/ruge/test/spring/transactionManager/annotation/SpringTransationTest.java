package com.ruge.test.spring.transactionManager.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-06  20:51
 * 描述 ： spring 事务测试
 */
public class SpringTransationTest {
    private ApplicationContext context = null;
    private IBookShopDao dao = null;
    private BookShopService service;
    private Cashier cashier;

    {
        context = new ClassPathXmlApplicationContext("classpath:test/spring/jdbcTemplate/applicationContext.xml");
        dao = (IBookShopDao) context.getBean("bookShopDaoImpl");
        service = (BookShopService) context.getBean("bookShopServiceImpl");
        cashier = (Cashier) context.getBean("cashierImpl");
    }

    @Test
    public void TestFindPriceByIsbn() {
        System.out.println(dao.findBookPriceByIsbn("1"));
    }

    @Test
    public void udateBookStockByisbn() {
        dao.updateBookStock("1");
    }

    /**
     * 更新账户余额
     */
    @Test
    public void updateUserAccount() {
        dao.updateUserAccount("张三", 5000);
    }

    /**
     * 买书
     */
    @Test
    public void testBookShopService(){
        service.purchase("张三","1");
    }

    /**
     * 测试事务的传播行为
     */
    @Test
    public void testTransactionlPropagation(){
        cashier.checkout("张三", Arrays.asList("1", "2"));
    }
}
