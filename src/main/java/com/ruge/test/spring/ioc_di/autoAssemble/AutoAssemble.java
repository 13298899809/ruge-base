package com.ruge.test.spring.ioc_di.autoAssemble;

import lombok.Data;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-05  9:03
 * 描述 ：
 */
@Data
public class AutoAssemble {
    private int id;
    private String name;
    private int age;
    private Dog dog;
  /*  public AutoAssemble(Dog dog){
        super();
        this.dog=dog;
    }*/
}
