package com.ruge.test.jdk新特性.jdk8.引用;

import org.junit.Test;

import java.util.function.BiPredicate;

/**
 * 爱丽丝、如歌  创建于 2018/6/1 13:15
 * 说明:  demo03_类__实例方法名
 */
public class demo03_类__实例方法名 {
    @Test
    public void test1() {
        BiPredicate<String, String> biPredicate = (a, b) -> a.equals(b);
        boolean test = biPredicate.test(" ", "  ");
        System.out.println(test);
        BiPredicate<String, String> biPredicate2 = String::equals;
        boolean test1 = biPredicate2.test("a", "a");
        System.out.println(test1);
    }
}
