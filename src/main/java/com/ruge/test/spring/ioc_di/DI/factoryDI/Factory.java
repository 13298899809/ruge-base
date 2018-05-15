package com.ruge.test.spring.ioc_di.DI.factoryDI;
/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-04  21:18
 * 描述 ：
 */
public class Factory {
    private FactoryDI createFactoryDI(){
        FactoryDI factoryDI = new FactoryDI();
        factoryDI.setId(5);
        factoryDI.setName("王菲");
        factoryDI.setAge(18);
        return factoryDI;
    }
}
