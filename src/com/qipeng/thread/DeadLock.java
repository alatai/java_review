package com.qipeng.thread;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/13 14:18
 */
public class DeadLock {

    public static void main(String[] args) throws InterruptedException {
        DeadLock obj1 = new DeadLock("obj1");
        DeadLock obj2 = new DeadLock("obj2");

        Runnable runA = () -> {
            try {
                obj1.checkOther(obj2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread threadA = new Thread(runA, "threadA");
        threadA.start();

        Thread.sleep(200);

        Runnable runB = () -> {
            try {
                obj2.checkOther(obj1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread threadB = new Thread(runB, "threadB");
        threadB.start();

        Thread.sleep(5000);
        threadPrint("finish sleeping");
        threadPrint("about to interrupt() threadA");
        threadA.interrupt();

        Thread.sleep(1000);
        threadPrint("finish sleeping");
        threadPrint("about to interrupt() threadB");
        threadB.interrupt();
        
        Thread.sleep(1000);

        threadPrint("did that break the deadlock?");

    }

    private final String objId;

    public DeadLock(String objId) {
        this.objId = objId;
    }

    public synchronized void checkOther(DeadLock other) throws InterruptedException {
        print("entering checkOther()");
        Thread.sleep(2000);
        print("in checkOther() - about to invoke 'other.action()''");

        // 调用other对象的action方法，由于该方法是同步方法，因此会试图获取other对象的对象锁
        other.action();
        print("leaving checkOther()");
    }

    public synchronized void action() throws InterruptedException {
        print("entering action()");
        Thread.sleep(500);
        print("leaving action()");
    }

    public void print(String msg) {
        threadPrint("objId = " + objId + " - " + msg);
    }

    public static void threadPrint(String msg) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": " + msg);
    }
}
