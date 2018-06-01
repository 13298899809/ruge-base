package com.ruge.test.jdk新特性.jdk8.引用;

import org.junit.Test;

import java.util.function.Function;

/**
 * 爱丽丝、如歌  创建于 2018/6/1 13:46
 * 说明:  TODO
 */
public class demo05_数组引用 {
    @Test
    public void test(){
        Function<Integer, String[]> fun=(len)->new String[len]   ;
        String[] arr = fun.apply(10)    ;
        System.out.println(arr.length)  ;
        Function<Integer, String[]> fun2=String[]::new    ;
        System.out.println(fun2.apply(20).length);
    }
}
