package com.ruge.test.junit.junit4;

import org.junit.*;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void jia() {
        /**
         * 运行结果测试
         * assertEquals(期望值,返回值);
         */
        assertEquals(3, new Calculator().jia(1, 2));
    }

    @Test
    public void jian() {
        /**
         * 运行结果测试
         * assertEquals(期望值,返回值);
         */
        assertEquals(-1, new Calculator().jian(1, 2));
    }

    @Test
    public void cheng() {
        /**
         * 运行结果测试
         * assertEquals(期望值,返回值);
         */
        assertEquals(2, new Calculator().cheng(1, 2));
    }

    @Test
    public void chu() {
        /**
         * 运行结果测试
         * assertEquals(期望值,返回值);
         */
        assertEquals(2, new Calculator().chu(5, 0));
        System.out.println("chu");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp()");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown()");
    }

    @BeforeClass
    public static void openConn() {
        System.out.println("资源开启");
    }

    @AfterClass
    public static void closeConn() {
        System.out.println("资源关闭");

    }
    @Ignore
    @Test(timeout = 100)
    public void testTimeOut() {
        int i = 0;
        while (true) {
            System.out.println(i++);
        }
    }
}