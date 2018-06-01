package com.ruge.test.jdk新特性.jdk8.函数式接口;

import javafx.css.Match;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 爱丽丝、如歌  创建于 2018/6/1 11:28
 * 说明:  demo02_Supplier_供给型接口
 */
public class demo02_Supplier_供给型接口 {
    @Test
    public void test(){
    List list = getList(4,()->(Math.random()*100));
    list.forEach(System.out::println);
    }

    /**
     * 生成指定个数的整数  并放入list集合中
     * @param i 生成的个数
     * @param supplier 获取该整数
     * @return list集合
     */
    public List getList(int i , Supplier supplier){
        List list = new ArrayList();
        for (int j = 0; j <i ; j++) {
        Object o = supplier.get();
        list.add(o);
        }
        return list;
    }
}
