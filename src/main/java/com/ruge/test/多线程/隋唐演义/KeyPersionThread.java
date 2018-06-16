package com.ruge.test.多线程.隋唐演义;

/**
 * 爱丽丝、如歌  创建于 2018/6/11 15:23
 * 说明:  TODO
 */
public class KeyPersionThread  extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始战斗");
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"左突右杀  攻击随军");
        }
        System.out.println(Thread.currentThread().getName()+"结束战斗");
    }
}
