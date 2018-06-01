package com.ruge.test.jdk新特性.jdk8.函数式接口;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 爱丽丝、如歌  创建于 2018/6/1 11:29
 * 说明:  TODO
 */
public class demo04_Predicate断定型接口 {
    @Test
    public void test() {
        List<String> list = Arrays.asList("3123123", "123124", "fsfsa", "eteyh", "23423", "2321");
        List<String> newList = finterStr(list, (e) -> e.length() > 4);
        newList.forEach(System.out::println);
    }

    public List finterStr(List<String> list, Predicate<String> predicate) {
        List newList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (predicate.test(list.get(i))) {
                newList.add(list.get(i));
            }
        }
        return newList;
    }
}
