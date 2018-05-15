package com.ruge.test.spring.ioc_di.DI.annotationDI;

import org.springframework.stereotype.Repository;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-05  22:10
 * 描述 ：通过注解方式配置dao层
 */
@Repository
public class AnnotationRepository implements IAnnotationRepository {
    @Override
    public void save() {
        System.out.println("AnnotationRepository  save 。。。");
    }
}
