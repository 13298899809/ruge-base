package com.ruge.test.spring.aop;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-06  7:15
 * 描述 ：
 */
@Service
@Log
public class MathServiceILoggermpl implements IMathService {

    @Override
    public int add(int a, int b) {
        log.info("add start whth ["+a+","+b+"]");
        int res = a + b;
        log.info("add end whth ["+a+b+"]");
        return res;
    }

    @Override
    public int sub(int a, int b) {
        log.info("sub start whth ["+a+","+b+"]");
        log.info("sub end whth ["+(a-b)+"]");
        return a - b;
    }

    @Override
    public int mul(int a, int b) {
        log.info("mul start whth ["+a+","+b+"]");
        log.info("mul end whth ["+(a*b)+"]");
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        log.info("div start whth ["+a+","+b+"]");
        log.info("div end whth ["+(a/b)+"]");
        return a / b;
    }
}
