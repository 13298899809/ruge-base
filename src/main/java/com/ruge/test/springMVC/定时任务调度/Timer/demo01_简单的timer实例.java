package com.ruge.test.springMVC.定时任务调度.Timer;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 爱丽丝、如歌  创建于 2018/6/18 15:47
 * 说明:  TODO
 */
public class demo01_简单的timer实例 extends TimerTask {

    @Override
    public void run() {
        System.out.println("当前时间:"+LocalDateTime.now());
    }

    public static void main(String[] args) {
        // 1 创建一个timer实例
        Timer timer = new Timer();
        // 2 创建 一个 demo_01_简单的timer实例
        demo01_简单的timer实例 task = new demo01_简单的timer实例();
        // 3 通过timer 定时 定频率调用 task 的业务逻辑
            //  timer.schedule(task, new Date(), 1000)
            //  指定的任务    执行开始时间   执行间隔
        timer.schedule(task, new Date(), 1000);
    }
}
