package com.ruge.test.springMVC.定时任务调度.TimerTest.demo01_机器人;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 爱丽丝、如歌  创建于 2018/6/18 18:00
 * 说明:  机器人执行类
 */
public class ExecRobot {
    public static void main(String[] args) {

        Timer timer = new Timer();
        final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        System.out.println("当前执行的时间"+sf.format(calendar.getTime()));
        timer.schedule(new DanceRobot(),new Date(),2000);
        timer.schedule(new WaterRobot(timer),new Date(),2000);
        /**
         * 当水灌满之后,跳舞机器人再跳舞两秒后停止
         */
    }
}
