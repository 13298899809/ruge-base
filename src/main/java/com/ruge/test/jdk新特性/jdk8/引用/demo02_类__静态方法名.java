package com.ruge.test.jdk新特性.jdk8.引用;

import org.junit.Test;

import java.util.Comparator;

/**
 * 爱丽丝、如歌  创建于 2018/6/1 13:14
 * 说明:  demo02_类__静态方法名
 */
public class demo02_类__静态方法名 {
    @Test
    public void test1() {
        Comparator<Integer> comparator = (a, b) -> Integer.compare(a, b);
        int compare = comparator.compare(32, 4);
        System.out.println(compare);
        Comparator<Integer> comparator2 = Integer::compare;
        int compare1 = comparator2.compare(4, 5);
        System.out.println(compare1);
    }
}
