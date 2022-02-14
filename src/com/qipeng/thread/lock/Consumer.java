package com.qipeng.thread.lock;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/23 15:04
 */
public class Consumer implements Runnable {

    private Info info = null;

    public Consumer(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.info.get();
        }
    }
}
