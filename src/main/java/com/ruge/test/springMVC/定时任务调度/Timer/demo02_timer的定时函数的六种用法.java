package com.ruge.test.springMVC.定时任务调度.Timer;

import java.util.Date;
import java.util.Timer;

/**
 * 爱丽丝、如歌  创建于 2018/6/18 16:00
 * 说明:  timer的定时函数的几种用法
 */

/**
 * schedule(TimerTask task, Date time)
 * 在指定的时间安排指定的任务执行。
 * 执行且只执行一次
 */
public class demo02_timer的定时函数的六种用法 {
    public void test1() {
        Timer timer = new Timer();
        demo01_简单的timer实例 task = new demo01_简单的timer实例();

        timer.schedule(task, new Date());
    }

    /**
     * schedule(TimerTask task, Date firstTime, long period)
     * 从指定 的时间开始 ，对指定的任务执行重复的 固定延迟执行 。
     */
    public void test2() {
        Timer timer = new Timer();
        demo01_简单的timer实例 task = new demo01_简单的timer实例();
        timer.schedule(task, new Date(), 2000);
    }

    /**
     * schedule(TimerTask task, long delay)
     * 在指定的延迟之后安排指定的任务执行。
     * 先延迟 后执行
     */
    public void test3() {
        Timer timer = new Timer();
        demo01_简单的timer实例 task = new demo01_简单的timer实例();
        timer.schedule(task, 2000);
    }

    /**
     * schedule(TimerTask task, long delay, long period)
     * 在指定 的延迟之后开始 ，重新执行 固定延迟执行的指定任务。
     */
    public void test4() {
        Timer timer = new Timer();
        demo01_简单的timer实例 task = new demo01_简单的timer实例();
        timer.schedule(task, 2000, 2000);
    }

    /**
     * scheduleAtFixedRate(TimerTask task, Date firstTime, long period)
     * 从指定的时间 开始 ，对指定的任务执行重复的 固定速率执行 。
     */
    public void test5() {
        Timer timer = new Timer();
        demo01_简单的timer实例 task = new demo01_简单的timer实例();
        timer.scheduleAtFixedRate(task, new Date(), 2000);
    }

    /**
     * scheduleAtFixedRate(TimerTask task, long delay, long period)
     * 在指定的延迟之后 开始 ，重新执行 固定速率的指定任务。
     */
    public void test6() {
        Timer timer = new Timer();
        demo01_简单的timer实例 task = new demo01_简单的timer实例();
        timer.scheduleAtFixedRate(task, 2000, 2000);
    }

    /**
     * public void cancel()
     * 终止此计时器，丢弃任何当前计划的任务。 不干扰当前执行的任务（如果存在）。 一旦计时器被终止，它的执行线程就会顺利地终止，并且不会再安排任务了。
     * 请注意，在此定时器调用的定时器任务的运行方法内调用此方法绝对保证正在进行的任务执行是该定时器将执行的最后一个任务执行。
     * 这个方法可以重复调用; 第二个和以后的呼叫没有任何效果。
     */
    public void test7() {
        Timer timer = new Timer();
        timer.cancel();
    }

    public static void main(String[] args) {
        demo02_timer的定时函数的六种用法 demo = new demo02_timer的定时函数的六种用法();
        demo.test2();
    }

}
