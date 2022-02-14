package com.qipeng.thread.lock.interrupt;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/23 14:08
 */
public class Buffer {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Writer writer = new Writer(buffer);
        Reader reader = new Reader(buffer);

        writer.start();
        reader.start();

        new Thread(() -> {
            long start = System.currentTimeMillis();
            while (true) {
                if (System.currentTimeMillis() - start > 5000) {
                    System.out.println("不等了，尝试中断...");
                    reader.interrupt(); // 尝试中断读线程
                    break;
                }
            }
        }).start();
        // 期待“读”这个线程能退出等待锁，可是事与愿违，一旦读这个线程发现自己得不到锁
        // 就一直等待，就算它等到最后，也得不到锁。因为写线程要21亿秒才能完成，即使我们中断它
        // 它都不会响应。这时，ReentrantLock提供了一种机制让我们来响应中断
    }

    private final Object lock;

    public Buffer() {
        this.lock = this;
    }

    public void write() {
        synchronized (lock) {
            long startTime = System.currentTimeMillis();
            System.out.println("开始往这个buffer写入数据...");

            while (true) {
                if (System.currentTimeMillis() - startTime > Integer.MAX_VALUE) {
                    break;
                }
            }

            System.out.println("终于写完了...");
        }
    }

    public void read() {
        synchronized (lock) {
            System.out.println("从这个buffer读数据");
        }
    }
}
