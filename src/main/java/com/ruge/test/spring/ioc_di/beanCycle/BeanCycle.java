package com.ruge.test.spring.ioc_di.beanCycle;

import lombok.Data;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-05  20:33
 * 描述 ：bean的生命周期
 */
public class BeanCycle {
    private int id;
    private String name;
    public BeanCycle(){
        System.out.println("BeanCycle 构造器...");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName...");
        this.name = name;
    }
    public void init(){
        System.out.println("init ...");
    }

    public void destroy(){
        System.out.println("destroy ...");
    }
}
