package com.ruge.test.jdk新特性.jdk8.stream和filter;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * 爱丽丝、如歌  创建于 2018/6/1 14:13
 * 说明:  TODO
 */
public class demo01_streamAPI {

    List<JDK8User> list = Arrays.asList(
            new JDK8User("", "11", (int) (Math.random() * 1000)),
            new JDK8User("", "22", (int) (Math.random() * 1000)),
            new JDK8User("", "878", (int) (Math.random() * 1000)),
            new JDK8User("", "fasdf", (int) (Math.random() * 1000)),
            new JDK8User("", "rw", (int) (Math.random() * 1000)),
            new JDK8User("", "423", (int) (Math.random() * 1000)),
            new JDK8User("", "4", (int) (Math.random() * 1000)),
            new JDK8User("", "5", (int) (Math.random() * 1000)),
            new JDK8User("", "2", (int) (Math.random() * 1000))
    );

    @Test
    public void testforEach() {
        int limit = 123;
        list.stream()           /*创建stream*/
                .distinct()     /*distinct过滤*/
                .filter((e) -> e.getSalary() > 200)
                .limit(limit)
                .sorted((a,b)->a.getName().compareTo(b.getName()))
                .sorted(Comparator.comparing(JDK8User::getSalary).reversed()) /*根据工资进行排序*/
                .map(JDK8User::getName) /*只查询名字*/
                .forEach((e) -> System.out.println(e));
    }



    @Test
    public void testFindFirst() {
        Optional<JDK8User> first = list
                .stream()
                .findFirst();
        System.out.println(first);
    }
    @Test
    public void test聚合函数(){
    List<Integer> list = Arrays.asList(321,413,42,35,234,1,4,235,1,3,15,41,31,23,123);
        /**
         * 获取集合中暑
         */
        long count = list.stream().count();
        System.out.println(count);
        /**
         * 获取集合最大值
         */
        Integer integer = list.stream().max((a, b) -> a.compareTo(b)).get();
        System.out.println(integer);

        list.stream().sorted().forEach(e-> System.out.print(e+" "));

    }
}
