package com.ruge.test.日志.log4j;

import lombok.Data;
import lombok.extern.log4j.Log4j;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-12  0:39
 * 描述 ：
 */
@Data
public class Person {

    private String name;
    private int money;
    public static void main(String[] args) {
        Person person = new Person();
       // person.log.info("----------没有使用@Log4j 注解-----------");
    }

}
