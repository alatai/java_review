package com.qipeng.thread.pc;

/**
 * 消费者
 *
 * @author Alatai
 * @version 1.0
 * @date 2021/06/21 16:27
 */
public class Consumer implements Runnable {

    private final Info info;

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
