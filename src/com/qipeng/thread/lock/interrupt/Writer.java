package com.qipeng.thread.lock.interrupt;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/23 14:14
 */
public class Writer extends Thread{

    private final Buffer buffer;

    public Writer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.write();
    }
}
