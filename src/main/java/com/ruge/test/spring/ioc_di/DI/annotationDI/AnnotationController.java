package com.ruge.test.spring.ioc_di.DI.annotationDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-05  22:14
 * 描述 ：通过注解方式配置controller层
 */
@Controller
public class AnnotationController {
    /**
     * 自动注入
     * @Autowired byType 通过参数的数据类型自动自动装配，如果一个bean的数据类型和另外一个bean的property属性的数据类型兼容，就自动装配
     * @Resource byName 通过参数名 自动装配，如果一个bean的name 和另外一个bean的 property 相同，就自动装配。
     */
    @Autowired
    private AnnotationService service;

    public void exec() {
        service.save();
        System.out.println("AnnotationController.....");
    }
}
