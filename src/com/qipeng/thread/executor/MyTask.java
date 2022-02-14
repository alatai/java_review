package com.qipeng.thread.executor;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/22 14:49
 */
public class MyTask implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行...");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
