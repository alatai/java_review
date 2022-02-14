package com.qipeng.thread.pc;

/**
 * 测试生产者-消费者案例
 *
 * @author Alatai
 * @version 1.0
 * @date 2021/06/21 16:28
 */
public class TestPC {

    public static void main(String[] args) throws InterruptedException {
        Info info = new Info();
        Producer producer = new Producer(info);
        Consumer consumer = new Consumer(info);

        new Thread(producer).start();

        Thread.sleep(500);

        new Thread(consumer).start();
    }
}
