package com.ruge.test.jdk新特性.jdk8.函数式接口;

import org.junit.Test;

import java.util.function.Function;

/**
 * 爱丽丝、如歌  创建于 2018/6/1 11:28
 * 说明:  TODO
 */
public class demo03_Function_函数型接口 {
    @Test
    public void test() {
        String sub = strHandler("谁在悬崖沏一壶茶", (str) -> str.substring(2, 5));
        System.out.println(sub);
    }

    public String strHandler(String str, Function<String, String> function) {
        return function.apply(str);
    }
}
