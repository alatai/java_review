package com.qipeng.thread.executor;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/22 14:08
 */
public class Task implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程被调用了");
    }
}
