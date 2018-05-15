package com.ruge.test.mybatis.helloWorld.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-11  21:37
 * 描述 ：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String gender;
    private String email;
}
