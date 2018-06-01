package com.ruge.test.jdk新特性.jdk8.lambda表达式;

import org.junit.Test;

/**
 * 爱丽丝、如歌  创建于 2018/5/31 10:22
 * 说明:  lombda 排序
 *        () -> System.out.println("Hello Lambda!");
 */
public class demo01_无参数无返回值 {
    @Test
    public void testWithNoArgsNoReturnByJdk7() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
    }

    @Test
    public void testWithNoArgsNoReturnByJdk8() {
    Runnable r1 = ()-> System.out.println("222");
    }
}
