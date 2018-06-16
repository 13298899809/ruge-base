package com.ruge.test.多线程.隋唐演义;

/**
 * 爱丽丝、如歌  创建于 2018/6/11 13:23
 * 说明:  舞台开幕
 */
public class Action extends Thread {

    @Override
    public void run() {
        System.out.println("欢迎观看隋唐演义 请大家关闭手机 保持安静");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("大幕徐徐拉开");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("话说隋朝末年,民不聊生 .....");

        /**
         * 创建军队作战计划  new 对象
         */
        ArmyRunnable 隋朝 = new ArmyRunnable();
        ArmyRunnable 农民军 = new ArmyRunnable();
        /**
         * 创建线程
         */
        Thread 隋朝军队 = new Thread(隋朝);
        Thread 农民军军队 = new Thread(农民军);
        /**
         * 军队番号
         */
        隋朝军队.setName("隋军---");
        农民军军队.setName("农民军---");
        /**
         * 启动线程  让军队开始作战
         */
        隋朝军队.start();
        农民军军队.start();
        /**
         * 线程休眠50毫秒
         */
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("双方杀的正酣 半路杀出个程咬金");

        Thread mrCheng = new KeyPersionThread();
        mrCheng.setName("程咬金");

        System.out.println("程咬金的理想就是结束战争!");
        /**
         * 鸣金收兵
         */
        隋朝.KeepRunning = false;
        农民军.KeepRunning = false;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * 历史大戏留给程先生
         */
        mrCheng.start();
        /**
         * 万众瞩目 所有线程等待程先生完成历史使命
         */
        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("战争结束 人民安居乐业 程先生实现了人生梦想 为人民作出了贡献  ");

        System.out.println("谢谢大家的观看");
    }

    public static void main(String[] args) {
        Action action = new Action();
        action.start();
    }
}
