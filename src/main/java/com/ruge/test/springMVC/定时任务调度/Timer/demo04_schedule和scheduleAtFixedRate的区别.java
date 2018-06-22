package com.ruge.test.springMVC.定时任务调度.Timer;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 爱丽丝、如歌  创建于 2018/6/18 17:09
 * 说明:  TODO
 */
public class demo04_schedule和scheduleAtFixedRate的区别 {
    public static void main(String[] args) {
        // 定义时间格式
        final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获取当前的具体时间
        Calendar calendar = Calendar.getInstance();

        System.out.println("当前系统时间 : " + sf.format(calendar.getTime()));
        // 设置成6秒前的时间，若当前时间为2016-12-28 00:00:06
        // 那么设置之后时间变成2016-12-28 00:00:00
        calendar.add(Calendar.SECOND, -6);

        Timer timer = new Timer();

        // 第一次执行时间为6秒前，之后每隔两秒钟执行一次

        /**
         *schedule   超过执行周期  下一次执行时间相对于上一次实际执行完成的时间点，因此执行时间会不断延后
         *schedule   开始执行时间小于当前时间  如果第一次时间被延迟了,随后的执行时间按照上一次实际执行完成的时间点进行计算
         *scheduleAtFixedRate 超过执行周期  下一次执行时间相对于上一次开始的时间点，因此执行时间一般不会延后，因此存在并发性
         *scheduleAtFixedRate 开始执行时间小于当前时间  如果第一次指定时间被延迟了,随后执行时间按照上一次开始时间进行计算,并且为了赶上进度而多次执行任务,
         * 因此TimeTask 的执行体需要考虑同步
         */
        //timer.schedule(new TimerTask() {
             timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 打印当前的计划执行时间
                System.out.println("scheduleAtFixedRate 计划执行系统时间 : " + sf.format(scheduledExecutionTime()));
            }
        }, calendar.getTime(), 2000);
    }
}
