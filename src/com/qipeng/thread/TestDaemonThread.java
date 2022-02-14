package com.qipeng.thread;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/06 23:02
 */
public class TestDaemonThread {

    public static void main(String[] args) {
        Thread t = new MyThread();
        t.setDaemon(true);
        t.start();

        System.out.println("main: wait 3 sec...");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exp) {
            exp.printStackTrace();
        }

        System.out.println("main: end.");
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            while (true) {
                System.out.println("MyThread: running...");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException exp) {
                    exp.printStackTrace();
                }
            }
        }
    }
}
