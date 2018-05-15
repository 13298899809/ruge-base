package com.ruge.test.spring.aop.proxy;


import com.ruge.test.spring.aop.IMathService;
import lombok.extern.java.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-06  8:30
 * 描述 ：动态代理实现日志管理
 */
@Log
public class MathProxy {
    /**
     * 要代理的对象
     */
    private IMathService target;

    /**
     * 构造器
     */
    public MathProxy(IMathService target){
        this.target = target;
    }

    public IMathService getLoggerProxy() {
        IMathService proxy = null;

        /**
         * 代理对象由那个类加载器负责加载
         */
        ClassLoader loader = target.getClass().getClassLoader();
        /**
         * 代理对象类型 即其中有哪些方法
         */
        Class[] interfaces = new Class[]{IMathService.class};
        /**
         * 当调用代理对象其中的方法时 该执行代码在下面
         */
        InvocationHandler handler = new InvocationHandler() {
            /**
             *
             * @param proxy 正在返回的代理对象 一般情况下  在nvoke中都不使用代理对象
             * @param method 正在被调用的方法
             * @param args 调用方法时传入的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /**
                 * 日志
                 */
                log.info("the method is :"+method.getName() +"begin with "+ Arrays.asList(args));
                /**
                 * 执行方法
                 */
                Object result = method.invoke(target, args);
                log.info("the method"+method.getName()+" end with "+result);
                return 0;
            }
        };
        proxy = (IMathService) Proxy.newProxyInstance(loader,interfaces,handler);

        return proxy;
    }
}
