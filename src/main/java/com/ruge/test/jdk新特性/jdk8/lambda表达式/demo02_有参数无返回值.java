package com.ruge.test.jdk新特性.jdk8.lambda表达式;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * 爱丽丝、如歌  创建于 2018/5/31 10:22
 * 说明:  (x) -> System.out.println(x)
 */
public class demo02_有参数无返回值 {
    @Test
    public void testWithArgsNoReturnByJdk7() {
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        consumer.accept(233);
    }


    @Test
    public void testWithNoArgsNoReturnByJdk8() {
        Consumer<String> consumer = (o) -> System.out.println(o);
        consumer.accept("344");
    }
}
