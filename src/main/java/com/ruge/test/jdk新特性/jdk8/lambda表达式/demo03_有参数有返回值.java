package com.ruge.test.jdk新特性.jdk8.lambda表达式;

import org.junit.Test;

import java.util.Comparator;

/**
 * 爱丽丝、如歌  创建于 2018/6/1 10:19
 * 说明:  TODO
 */
public class demo03_有参数有返回值 {
    @Test
    public void test1() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return compare(o1,o2);
            }
        };
        comparator.compare(2,3);
    }

    /**
     * 有两个以上的参数，有返回值，并且 Lambda 体中有多条语句
     */
    @Test
    public void test2(){
        Comparator<Integer> comparator = (a,b)-> {
            System.out.println("函数式接口");
            return Integer.compare(a,b);
        };
    }
    /**
     * 若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写
     */
    @Test
    public void test3(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }
}
