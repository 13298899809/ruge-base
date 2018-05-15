package com.ruge.test.spring.ioc_di.DI.constructorDI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-04  20:56
 * 描述 ：构造函数注入
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConstructorDI {
    private int id;
    private String name;
    private int age;
}
