package com.ruge.test.springMVC.常用注解.JDK自带注解;

import java.util.ArrayList;
import java.util.List;

/**
 * 爱丽丝、如歌  创建于 2018/6/19 15:39
 * 说明:  TODO
 */
public class JDKTest {
    @SuppressWarnings(value = {"deprecated", "unchecked"})
    public void test1() {
        Person person = new XiaoMing();
        person.getName();
        person.getAge();
        List list = new ArrayList();
        list.add("小米");
    }
}
