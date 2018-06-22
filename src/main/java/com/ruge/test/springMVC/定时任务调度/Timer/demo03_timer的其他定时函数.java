package com.ruge.test.springMVC.定时任务调度.Timer;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 爱丽丝、如歌  创建于 2018/6/18 16:54
 * 说明:  TODO
 */
public class demo03_timer的其他定时函数 extends TimerTask {
        int count = 0;
    @Override
    public void run() {
        if(count<10){
        System.out.println(LocalDateTime.now());
            count ++;
        }else {
            cancel();
            System.out.println("task canel()");
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        demo03_timer的其他定时函数 task = new demo03_timer的其他定时函数();
        timer.schedule(task,200,200);
        System.out.println(task.scheduledExecutionTime());
    }
}
