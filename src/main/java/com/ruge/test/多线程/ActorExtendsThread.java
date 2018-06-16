package com.ruge.test.多线程;

import org.junit.Test;

/**
 * 爱丽丝、如歌  创建于 2018/6/11 13:08
 * 说明:  TODO
 */
public class ActorExtendsThread extends Thread {
    @Override
    public void run() {
        /**
         * 获取当前线程的名称
         */
        System.out.println(getName() + "是一位演员!");
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println(getName() + "出场" + (++count));
            if (count == 100) {
                keepRunning = false;
            }
            if (count % 7 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(getName() + "的演出结束!");
    }
}
