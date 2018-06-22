package com.ruge.test.springMVC.常用注解.JDK自带注解;

/**
 * 爱丽丝、如歌 创建于 2018/6/19 15:31
 * 说明:  jdk自带的注解
 */
public interface Person {
    public void getName();

    /**
     * 废弃的注解
     */
    @Deprecated
    public void getAge();
}
