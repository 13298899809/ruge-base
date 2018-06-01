package com.ruge.test.jdk新特性.jdk8.lambda表达式;

import org.junit.Test;

import java.util.*;

/**
 * 爱丽丝、如歌  创建于 2018/6/1 10:34
 * 说明:  lombda 遍历集合
 */
public class demo04_遍历 {
    /**
     * 遍历list集合
     */
    @Test
    public void testList() {
        List list = Arrays.asList(1, 2, 3, 4, 5, 6, 77, 8);
        list.forEach(System.out::println);
    }

    /**
     * 遍历set集合
     */
    @Test
    public void testSet() {
        Set set = new HashSet();
        set.add(1);
        set.add(3);
        set.add(4);
        set.add(16);
        set.add(17);
        set.add(18);
        set.forEach(System.out::println);
    }

    /**
     * 遍历map集合
     */
    @Test
    public void testMap() {
        Map map = new HashMap();
        map.put("1", "1");
        map.put("2", 2);
        map.put("3", true);
        map.put("4", Arrays.asList(1, 2, 3));
        map.forEach((key, value) -> {
            if ("4".equals(key)) {
                System.out.println(key + " " + value);
            }
        });
    }
}
