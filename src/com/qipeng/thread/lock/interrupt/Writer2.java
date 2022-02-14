package com.qipeng.thread.lock.interrupt;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/23 14:42
 */
public class Writer2 extends Thread {

    private final BufferInterruptibly buffer;

    public Writer2(BufferInterruptibly buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.write();
    }
}
