package com.ruge.test.jdk新特性.jdk8.引用;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 爱丽丝、如歌  创建于 2018/6/1 13:14
 * 说明:  demo01_对象__实例方法名
 */
public class demo01_对象__实例方法名 {
    @Test
    public void test1() {
        Consumer<String> consumer1 = (x) -> System.out.println(x);
        Consumer<String> consumer2 = System.out::println;
        consumer1.accept("1323");
        consumer2.accept("2323");
    }
}
