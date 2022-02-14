package com.qipeng.thread.lock.interrupt;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/23 14:15
 */
public class Reader extends Thread {

    private final Buffer buffer;

    public Reader(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.read(); // 会一直阻塞

        System.out.println("读结束...");
    }
}
