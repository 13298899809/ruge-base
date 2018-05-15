package com.ruge.test.spring.ioc_di.beanRelation;

import lombok.Data;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-05  8:13
 * 描述 ：bean之间的关系
 */
@Data
public class BeanRelation {
    private int id;
    private String name;
    private int age;
    private String className;
    private Dog dog;
}
