package com.ruge.test.springMVC.定时任务调度.ScheduledExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 爱丽丝、如歌  创建于 2018/6/18 19:06
 * 说明:  TODO
 */
public class demo02_ScheduledExecutorService解决并发问题 {
    public static void main(String[] args) {
        //启用2个线程
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        demo01_timer解决并发问题 task1 = new demo01_timer解决并发问题("一号",5000L);
        demo01_timer解决并发问题 task2 = new demo01_timer解决并发问题("二号",5000L);
        pool.scheduleWithFixedDelay(task1, 0, 2, TimeUnit.SECONDS);
        pool.scheduleWithFixedDelay(task2, 0, 2, TimeUnit.SECONDS);
    }
}
