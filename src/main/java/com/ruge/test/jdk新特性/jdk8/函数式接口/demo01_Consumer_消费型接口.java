package com.ruge.test.jdk新特性.jdk8.函数式接口;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * 爱丽丝、如歌  创建于 2018/6/1 11:26
 * 说明:  demo01_Consumer_消费型接口
 */
public class demo01_Consumer_消费型接口 {
    @Test
    public void test() {
        happy(100, (e) -> System.out.println("游戏充值了"+e+"元"));
    }

    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }
}
