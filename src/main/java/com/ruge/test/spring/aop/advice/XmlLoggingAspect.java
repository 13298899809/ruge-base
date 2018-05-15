package com.ruge.test.spring.aop.advice;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
* 创建人 ：爱丽丝、如歌
* 创建时间 ：2018-05-06  9:11
* 描述 ：日志切换
 *      @Order(1)  如果多个切面共同监听同一个方法  可以使用@Order设置优先级  控制切面的调用顺序 1最小 100最大（数据越小优先级越高）
*/
@Log
public class XmlLoggingAspect {

    public void doBefore(JoinPoint joinPoint){
        String meethodName = joinPoint.getSignature().getName();
        Object [] args = joinPoint.getArgs();
        log.info("方法开始啦。。。。。。"+meethodName+"参数："+Arrays.asList(args));
    }


    public void doAfter(JoinPoint joinPoint){
        String meethodName = joinPoint.getSignature().getName();
        Object [] args = joinPoint.getArgs();
        log.info("方法结束啦。。。。。。"+meethodName+"参数："+Arrays.asList(args));
    }


    public void AfterReturning(JoinPoint joinPoint,Object result){
        String meethodName = joinPoint.getSignature().getName();
        Object [] args = joinPoint.getArgs();
        log.info("方法的结果返回啦。。。。。。"+meethodName+"参数："+Arrays.asList(args)+"返回值是："+result);
    }


    public void AfterThrowing(JoinPoint joinPoint,Exception exception){
        String meethodName = joinPoint.getSignature().getName();
        Object [] args = joinPoint.getArgs();
        log.info("方法出现异常了。。。。。。"+meethodName+"参数："+Arrays.asList(args)+"返回值是："+exception);
    }


    public Object Around(ProceedingJoinPoint point){
        Object result = null;
            String methodName = point.getSignature().getName();
        try {
            /**
             * 前置通知
             */
            System.out.println("环绕的前置通知 The method " + methodName + " begins with " + Arrays.asList(point.getArgs()));
            /**
             * 执行目标方法
             */
            result = point.proceed();
            /**
             * 返回通知
             */
            System.out.println("环绕的 返回通知 The method " + methodName + " ends with " + result);
        } catch (Throwable e) {
            /**
             * 异常通知
             */
            System.out.println("环绕的 异常通知 The method " + methodName + " occurs exception:" + e);
            throw new RuntimeException(e);
        }
        /**
         * 后置通知
         */
        System.out.println("环绕的 后置通知 The method " + methodName + " ends");
        return result;
    }
}
