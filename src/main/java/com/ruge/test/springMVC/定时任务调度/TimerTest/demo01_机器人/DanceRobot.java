package com.ruge.test.springMVC.定时任务调度.TimerTest.demo01_机器人;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 爱丽丝、如歌  创建于 2018/6/18 17:53
 * 说明:  跳舞机器人
 */
public class DanceRobot extends TimerTask {
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void run() {
        /**
         * 获取最近的一次的任务执行时间
         */
        System.out.println("计划执行时间"+sf.format(scheduledExecutionTime()));
        System.out.println("跳舞吧");
    }
}
