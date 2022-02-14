package com.qipeng.thread.lock.interrupt;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/23 14:40
 */
public class Reader2 extends Thread {

    private final BufferInterruptibly buffer;

    public Reader2(BufferInterruptibly buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            buffer.read();
        } catch (InterruptedException e) {
            System.out.println("不读了...");
        }

        System.out.println("读结束...");
    }
}
