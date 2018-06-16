package com.ruge.test.多线程.demo02_atomic;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 爱丽丝、如歌  创建于 2018/6/12 9:50
 * 说明:  原子性
 *          CAS算法保证数据原子性
 *          内存值 V
 *          预估值 A
 *          更细值 B
 *          当且仅当 V ==A V ==B 否则将不做处理
 */
public class TestAtomic implements Runnable {
    /**
     * 初始值为0
     */
   // private int serialNumber = 0;

    private AtomicInteger serialNumber = new AtomicInteger();

    public int getSerialNumber() {
      //  return serialNumber++;
        /**
         * 获取并递增
         */
        return serialNumber.getAndIncrement();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber());
    }

    public static void main(String[] args) {
        TestAtomic atomic = new TestAtomic();
        /**
         * 创建十个线程访问该方法
         */
        for (int i = 0; i < 10; i++) {
            new Thread(atomic).start();
        }
    }
}
