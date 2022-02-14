package com.qipeng.thread;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/06 16:52
 */
public class TestThread {

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();

        Thread thread1 = new Thread(new MyThread1());
        thread1.start();

        // lambda 表达式
        Thread thread2 = new Thread(() -> System.out.println("start new thread by lambda!"));
        thread2.start();
    }

    // 方式一：继承Thread类
    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("start new thread!");
        }
    }

    // 方式二：实现Runnable接口
    static class MyThread1 implements Runnable {

        @Override
        public void run() {
            System.out.println("start new thread1!");
        }
    }
}
