package com.ruge.test.spring.ioc_di.DI.genericDI;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-05  23:24
 * 描述 ：泛型依赖注入 base
 */
public class BaseGenericDIRepository<T> {
    public void add() {
        System.out.println("BaseGenericDIRepository add ....");
    }
}
