package com.ruge.test.springMVC.定时任务调度.ScheduledExecutorService;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 爱丽丝、如歌  创建于 2018/6/18 18:42
 * 说明:  TODO
 */
public class demo01_timer解决并发问题 extends TimerTask {
    private String name;
    private Long time;

    public demo01_timer解决并发问题(String inputName, Long inputTime) {
        name = inputName;
        time = inputTime;
    }

    @Override
    public void run() {
        System.out.println(name+" 开始执行时间 " + LocalDateTime.now());
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+" 结束执行时间 " + LocalDateTime.now());
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        demo01_timer解决并发问题 task1 = new demo01_timer解决并发问题("一号",5000L);
        demo01_timer解决并发问题 task2 = new demo01_timer解决并发问题("二号",5000L);
        timer.schedule(task1, 2000, 2000);
        timer.schedule(task2, 2000, 2000);
    }
}
