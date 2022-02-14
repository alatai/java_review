package com.qipeng.thread;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/06 22:19
 */
public class TestVolatile {

    public static void main(String[] args) throws InterruptedException {
        HelloThread t = new HelloThread();
        t.start();
        Thread.sleep(1);
        t.running = false;
    }

    static class HelloThread extends Thread {

        public volatile boolean running = true;

        @Override
        public void run() {
            int n = 0;

            while (running) {
                n ++;
                System.out.println(n + " Hello!");
            }

            System.out.println("end.");
        }
    }
}
