package com.ruge.test.springMVC.定时任务调度.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Collection;

/**
 * 爱丽丝、如歌  创建于 2018/6/22 15:26
 * 说明:  TODO
 */
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {
        /**
         * 创建一个jobDetail 将该实例于helloJob绑定
         */
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("my job1", "group1").usingJobData("message","hello Myjob1").usingJobData("floatJobValue",3.14F).build();
        System.out.println(jobDetail.getKey().getName());
        System.out.println(jobDetail.getKey().getGroup());
        System.out.println(jobDetail.getJobClass().getName());
        /**
         * 创建一个trigger 实例 定义该job立即执行  并且没两秒钟执行一次
         */
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("my trigger", "group1").usingJobData("message","hello myTrigger 1").usingJobData("DoubleTriggerValue",20.2D).startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();
        /**
         * 创建Scheduler实例
         */
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);
    }
}
