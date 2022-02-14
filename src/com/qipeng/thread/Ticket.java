package com.qipeng.thread;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/08 11:42
 */
public class Ticket {

    public static void main(String[] args) {
        // new MyThread().start();
        // new MyThread().start();
        // new MyThread().start();

        MyThread1 my = new MyThread1();
        new Thread(my).start();
        new Thread(my).start();
        new Thread(my).start();
    }

    static class MyThread extends Thread {
        private int ticket = 5;

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                if (ticket > 0) {
                    System.out.println("ticket = " + ticket--);
                }
            }
        }
    }

    static class MyThread1 implements Runnable {
        private int ticket = 5;

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                if (ticket > 0) {
                    System.out.println("ticket = " + ticket--);
                }
            }
        }
    }
}
