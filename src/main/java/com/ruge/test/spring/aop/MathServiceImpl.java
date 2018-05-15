package com.ruge.test.spring.aop;


import org.springframework.stereotype.Component;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-06  7:15
 * 描述 ：
 */
@Component
public class MathServiceImpl implements IMathService {

    @Override
    public int add(int a, int b) {
        int res = a + b;
        return res;
    }

    @Override
    public int sub(int a, int b) {
        int res =  a - b;
        return res;
    }

    @Override
    public int mul(int a, int b) {
        int res = a * b;
        return res;
    }

    @Override
    public int div(int a, int b) {
        int res = a / b;
        return res;
    }
}
