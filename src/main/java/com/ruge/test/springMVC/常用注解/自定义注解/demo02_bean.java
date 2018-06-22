package com.ruge.test.springMVC.常用注解.自定义注解;

import lombok.Data;

/**
 * 爱丽丝、如歌  创建于 2018/6/21 19:29
 * 说明:  TODO
 */
@Data
@TableName("girl")
public class demo02_bean {
    @ColumnName("id")
    private String id;
    @ColumnName("name")
    private String name;
}
