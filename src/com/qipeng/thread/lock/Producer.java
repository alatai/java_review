package com.qipeng.thread.lock;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/23 15:02
 */
public class Producer implements Runnable {

    private final Info info;

    public Producer(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        boolean flag = true;

        for (int i = 0; i < 10; i++) {
            if (flag) {
                this.info.set("姓名--1", "内容--1");
                flag = false;
            } else {
                this.info.set("姓名--2", "内容--2");
                flag = true;
            }
        }
    }
}
