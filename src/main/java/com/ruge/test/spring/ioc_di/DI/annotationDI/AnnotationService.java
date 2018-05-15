package com.ruge.test.spring.ioc_di.DI.annotationDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-05  22:13
 * 描述 ：通过注解方式配置service层
 */
@Service
public class AnnotationService implements IAnnotationService {
    @Autowired
    private AnnotationRepository repository;
    @Override
    public void save() {
        repository.save();
        System.out.println("AnnotationService save .....");
    }
}
