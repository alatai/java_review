package com.qipeng.thread;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/07 22:53
 */
public class TestSynchronized {

    public static void main(String[] args) throws InterruptedException {
        var add = new AddThread();
        var dec = new DecThread();

        add.start();
        dec.start();
        add.join();
        dec.join();

        System.out.println(Counter.count);
    }

    static class Counter {
        public static final Object lock = new Object();
        public static int count = 0;
    }

    static class AddThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                synchronized (Counter.lock) {
                    Counter.count++;
                }
            }
        }
    }

    static class DecThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                synchronized (Counter.lock) {
                    Counter.count--;
                }
            }
        }
    }
}
