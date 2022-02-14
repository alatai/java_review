package com.qipeng.thread.lock;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/23 15:08
 */
public class ThreadCaseDemo {

    public static void main(String[] args) throws InterruptedException {
        Info info = new Info();

        Producer producer = new Producer(info);
        Consumer consumer = new Consumer(info);

        new Thread(producer).start();

        Thread.sleep(500);

        new Thread(consumer).start();
    }
}
