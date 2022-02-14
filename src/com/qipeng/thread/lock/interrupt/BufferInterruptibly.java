package com.qipeng.thread.lock.interrupt;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/23 14:28
 */
public class BufferInterruptibly {

    public static void main(String[] args) {
        BufferInterruptibly buffer = new BufferInterruptibly();

        Writer2 writer = new Writer2(buffer);
        Reader2 reader = new Reader2(buffer);

        writer.start();
        reader.start();

        new Thread(() -> {
            long start = System.currentTimeMillis();
            while (true) {
                if (System.currentTimeMillis() - start > 5000) {
                    System.out.println("不等了，尝试中断...");
                    reader.interrupt();
                    break;
                }
            }
        }).start();
    }

    private final ReentrantLock lock = new ReentrantLock();

    public void write() {
        lock.lock();

        try {
            long startTime = System.currentTimeMillis();
            System.out.println("开始往这个buffer写数据...");

            while (true) {
                if (System.currentTimeMillis() - startTime > Integer.MAX_VALUE) {
                    break;
                }
            }

            System.out.println("终于写完了...");
        } finally {
            lock.unlock();
        }
    }

    public void read() throws InterruptedException {
        lock.lockInterruptibly(); // 表示可以响应中断

        try {
            System.out.println("从这个buffer读数据");
        } finally {
            lock.unlock();
        }
    }
}
