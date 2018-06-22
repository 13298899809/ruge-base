package com.ruge.test.springMVC.定时任务调度.TimerTest.demo01_机器人;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 爱丽丝、如歌  创建于 2018/6/18 17:56
 * 说明:  灌水机器人
 */
public class WaterRobot extends TimerTask {
    private Timer timer;
    public Integer min = 0;
    public Integer max = 5;

    public WaterRobot(Timer inputTimer) {
        timer = inputTimer;
    }

    @Override
    public void run() {
        if (min >= max) {
            cancel();
            System.out.println("水已经灌满了 可以停止工作了,已被取消的任务数量"+timer.purge());
            /**
             * 等待两秒中 停止Timer内的所有内容
             */
            try {
                Thread.sleep(2000);
                timer.cancel();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("灌水一升成功,距离水满还需要灌水" + (max - min) + "次");
            min++;
        }

    }
}
