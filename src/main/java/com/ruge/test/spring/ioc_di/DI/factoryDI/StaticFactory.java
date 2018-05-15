package com.ruge.test.spring.ioc_di.DI.factoryDI;



/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-04  21:18
 * 描述 ：静态工厂方法
 */
public class StaticFactory {
    private static FactoryDI createStaticFactoryDI(){
        FactoryDI factoryDI = new FactoryDI();
        factoryDI.setId(6);
        factoryDI.setName("王杰");
        factoryDI.setAge(18);
        return factoryDI;
    }
}
