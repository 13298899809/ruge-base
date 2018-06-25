package com.ruge.test.springMVC.定时任务调度.quartz;

import org.quartz.*;

import java.time.LocalDateTime;

/**
 * 爱丽丝、如歌  创建于 2018/6/22 15:23
 * 说明:  编写业务逻辑
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        /**
         * 打印当前的执行时间
         */
        System.out.println(LocalDateTime.now());
        JobKey key = jobExecutionContext.getJobDetail().getKey();
        TriggerKey key1 = jobExecutionContext.getTrigger().getKey();
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        JobDataMap jobDataMap1 = jobExecutionContext.getTrigger().getJobDataMap();
        String message = jobDataMap.getString("message");
        float floatJobValue = jobDataMap.getFloat("floatJobValue");
        String message1 = jobDataMap1.getString("message");
        double aDouble = jobDataMap1.getDouble("DoubleTriggerValue");
       // System.out.println("JobKey==="+key.getName()+":"+key.getGroup()+" TriggerKey==="+key1.getName()+":"+key1.getGroup());
    }
}
