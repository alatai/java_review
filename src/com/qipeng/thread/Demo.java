package com.qipeng.thread;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/06 17:04
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1000); // 暂停1毫秒
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            Thread hello = new HelloThread();
            hello.start();

            try {
                hello.join(); // 等待hello线程结束
            } catch (InterruptedException exp) {
                exp.printStackTrace();
            }

            hello.interrupt();
        }
    }

    static class HelloThread extends Thread {

        @Override
        public void run() {
            int n = 0;
            while (!isInterrupted()) {
                n++;
                System.out.println(n + " Hello!");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException exp) {
                    exp.printStackTrace();
                    break;
                }
            }
        }
    }

    private static void testJoin() throws InterruptedException {
        Thread t = new Thread(() -> System.out.println("Hello"));

        System.out.println("start");

        t.start();
        t.join(); // 等待t线程结束

        System.out.println("end");
    }

    private static void testSleep() {
        System.out.println("main start..");

        Thread t = new Thread(() -> {
            System.out.println("thread run..");

            try {
                Thread.sleep(10);
            } catch (InterruptedException exp) {
                exp.printStackTrace();
            }

            System.out.println("thread end.");
        });

        t.start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException exp) {
            exp.printStackTrace();
        }

        System.out.println("main end.");
    }
}
