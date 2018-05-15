package com.ruge.test.spring.ioc_di.DI.propertiesDI;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-04  20:45
 * 描述 ：属性注入
 */
@Data
public class PropertiesDI {
    private int id;
    private String name;
    private int age;
    /**
     * 当使用级联注入的时候  必须new 一个对象  否则报错
     */
    private Dog dog = new Dog();
    private List<String> hobbyies;
    private Set<String> loves;
    private Map<Object,String> works;
    private Properties property;
}
