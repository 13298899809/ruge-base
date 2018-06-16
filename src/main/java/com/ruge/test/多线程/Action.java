package com.ruge.test.多线程;

import com.ruge.test.多线程.隋唐演义.ArmyRunnable;

/**
 * 爱丽丝、如歌  创建于 2018/6/11 13:23
 * 说明:  舞台开幕
 */
public class Action{
    public static void main(String[] args) {
        Thread actor = new ActorExtendsThread();
        actor.setName("Mr Thread");
        actor.start();
        Thread actress = new Thread(new ActressImplementsRunnable());
        actress.setName("Ms Runnable");
        actress.start();

    }
}
