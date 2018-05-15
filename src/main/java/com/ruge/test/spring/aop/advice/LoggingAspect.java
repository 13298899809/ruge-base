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
@Order(1)
@Log
@Aspect
@Component
public class LoggingAspect {

    /**
     * 定义一个方法  用于声明切入点表达式 一般情况下  该方法不需要添加其他代码
     */
    @Pointcut("execution(* com.ruge.test.spring.aop.*.*(..))")
    public void declareJoinPointExpression(){

    }



/**
 *  声明该方法在那些类的那些方法之前执行
 *  @Before() 该方法是一个前置通知： 在目标方法开始回之前执行
 *  @param joinPoint 切入点
 *  Aspectj切入点语法定义
 *         execution(*  com.ruge.test.spring.aop.MathServiceImpl..*.*(..))
 *                   1、execution(): 表达式主体。
 *                   2、第一个*号：表示返回类型，*号表示所有的类型。
 *                   3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.ruge.test.spring.aop.MathServiceImpl包、子孙包下所有类的方法。
 *                   4、第二个*号：表示类名，*号表示所有的类。
 *                   5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。
 *
 * */
    @Before("declareJoinPointExpression()")
    public void doBefore(JoinPoint joinPoint){
        String meethodName = joinPoint.getSignature().getName();
        Object [] args = joinPoint.getArgs();
        log.info("方法开始啦。。。。。。"+meethodName+"参数："+Arrays.asList(args));
    }

    /**
     * 后置通知 在目标方法执行之后（无论是否异常）， 执行的通知
     * @param joinPoint 切入点
     */
    @After("declareJoinPointExpression()")
    public void doAfter(JoinPoint joinPoint){
        String meethodName = joinPoint.getSignature().getName();
        Object [] args = joinPoint.getArgs();
        log.info("方法结束啦。。。。。。"+meethodName+"参数："+Arrays.asList(args));
    }

    /**
     * 返回通知 在方法正常结束后的代码 可以获取方法返回值的
     * @param joinPoint 切入点
     */
    @AfterReturning(value = "declareJoinPointExpression()",
    returning = "result")
    public void AfterReturning(JoinPoint joinPoint,Object result){
        String meethodName = joinPoint.getSignature().getName();
        Object [] args = joinPoint.getArgs();
        log.info("方法的结果返回啦。。。。。。"+meethodName+"参数："+Arrays.asList(args)+"返回值是："+result);
    }

    /**
     * 异常通知 在目标方法出现异常的时候会在执行的代码 可以访问到异常对象 且可以指定在出现特定异常时执行
     * @param joinPoint 切入点
     * @param exception 异常信息
     */
    @AfterThrowing(value = "execution(* com.ruge.test.spring.aop.*.*(..))",
    throwing = "exception")
    public void AfterThrowing(JoinPoint joinPoint,Exception exception){
        String meethodName = joinPoint.getSignature().getName();
        Object [] args = joinPoint.getArgs();
        log.info("方法出现异常了。。。。。。"+meethodName+"参数："+Arrays.asList(args)+"返回值是："+exception);
    }

    /**
     * 环绕通知 需要携带ProceedingJoinPoint类型的参数
     * 环绕通知类似于动态代理的全过程 ProceedingJoinPoint类型的参数可以决定是否执行目标方法
     * 环绕通知必须有返回值 返回值即为目标方法的返回值
     * @param point 切入点
     */
    @Around(value = "execution(* com.ruge.test.spring.aop.*.*(..))")
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
