package com.qipeng.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/23 14:46
 */
public class Info {

    private String name;
    private String content;
    private boolean flag = true;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void set(String name, String content) {
        lock.lock();

        try {
            while (!flag) {
                condition.await();
            }

            this.setName(name);
            Thread.sleep(300);
            this.setContent(content);

            flag = false;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        lock.lock();

        try {
            while (flag) {
                condition.await();
            }

            Thread.sleep(300);
            System.out.println(this.getName() + " -> " + this.getContent());

            flag = true;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
