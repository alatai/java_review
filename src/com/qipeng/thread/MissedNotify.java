package com.qipeng.thread;

/**
 * 遗漏通知的代码
 *
 * @author Alatai
 * @version 1.0
 * @date 2021/06/16 12:30
 */
public class MissedNotify {

    public static void main(String[] args) throws InterruptedException {
        final MissedNotify missedNotify = new MissedNotify();

        Runnable runA = () -> {
            try {
                // 休眠1000ms，大于runB中的500ms
                // 为了后调用waitToProceed，而先调用notifyAll()后wait()
                Thread.sleep(1000);
                missedNotify.waitToProceed();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread threadA = new Thread(runA, "threadA");
        threadA.start();

        Runnable runB = () -> {
            try {
                Thread.sleep(500);
                missedNotify.proceed();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };


        Thread threadB = new Thread(runB, "threadB");
        threadB.start();

        Thread.sleep(10000);

        // 试图打断wait阻塞
        print("about to invoke interrupt() on threadA");
        threadA.interrupt();
    }

    private final Object proceedLock;

    public MissedNotify() {
        print("in MissedNotify()");
        proceedLock = new Object();
    }

    private void waitToProceed() throws InterruptedException {
        print("in waitToProceed() - entered");

        synchronized (proceedLock) {
            print("in waitToProceed() - about to wait()");
            proceedLock.wait();
            print("in waitToProceed() - back from wait()");
        }

        print("in waitToProceed() - leaving");
    }

    private void proceed() {
        print("in proceed() - entered");

        synchronized (proceedLock) {
            print("in proceed() - about to notifyAll()");
            proceedLock.notifyAll();
            print("in proceed() - back from notifyAll()");
        }

        print("in proceed() - leaving");
    }

    private static void print(String msg) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ": " + msg);
    }
}
