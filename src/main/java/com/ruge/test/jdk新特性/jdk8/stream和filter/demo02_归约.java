package com.ruge.test.jdk新特性.jdk8.stream和filter;

import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 爱丽丝、如歌  创建于 2018/6/1 16:34
 * 说明:  TODO
 */
public class demo02_归约 {
    @Test
    public void testReduce() {
        List<Integer> list = Arrays.asList(12, 133, 42, 35, 345, 64, 45, 6, 23, 5, 35, 236, 235, 3, 5, 35, 2);
        Integer sum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }

    /**
     * 收集
     */
    @Test
    public void testCollect() {
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
        list.stream()
                .map(JDK8User::getName)
                .collect(Collectors.toList())
                .forEach((e) -> System.out.println(e));

        Double avg = list.stream()
                .collect(Collectors.averagingInt(JDK8User::getSalary));
        System.out.println(avg);
        IntSummaryStatistics count_sum_min_avg_max = list.stream().collect(Collectors.summarizingInt(JDK8User::getSalary));
        System.out.println(count_sum_min_avg_max);
    }

}
