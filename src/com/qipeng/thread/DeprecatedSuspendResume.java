package com.qipeng.thread;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/08 14:52
 */
public class DeprecatedSuspendResume implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        System.out.println( 1f == 0.999999999f );

        test();
    }

    private static void test()throws InterruptedException {
        DeprecatedSuspendResume dsr = new DeprecatedSuspendResume();
        Thread t = new Thread(dsr);
        t.start();

        Thread.sleep(1000);

        for (int i = 0; i < 10; i++) {
            // t.suspend(); // 挂起线程（废弃）
            dsr.suspendRequest();
            // 休眠时间一定要大于stepOne操作对firstVal赋值后的休眠时间（300ms)
            Thread.sleep(350);

            System.out.println("dsr.isValueEqual() = " + dsr.isValueEqual());
            // t.resume(); // 恢复线程（废弃）
            dsr.resumeRequest();
            Thread.sleep((long) (Math.random() * 2000.0));
        }

        System.exit(0); // 中断应用程序
    }

    private volatile int firstVal;
    private volatile int secondVal;
    // 增加标志位，用来实现线程的挂起和恢复
    private volatile boolean suspended;

    public boolean isValueEqual() {
        return this.firstVal == this.secondVal;
    }

    @Override
    public void run() {
        try {
            this.firstVal = 0;
            this.secondVal = 0;
            this.suspended = false;
            workMethod();
        } catch (InterruptedException exp) {
            System.out.println("interrupted with in workMethod");
        }
    }

    private void workMethod() throws InterruptedException {
        int val = 1;
        while (true) {
            // 仅当线程挂起时
            waitWhileSuspended();

            stepOne(val);
            stepTwo(val);
            val++;

            // 仅当线程挂起时
            // waitWhileSuspended();

            Thread.sleep(200);
        }
    }

    private void stepOne(int val) throws InterruptedException {
        firstVal = val;
        // 模拟长时间运行的情况
        // 赋值后，休眠300毫秒，从而使线程有机会在stepOne操作和stepTwo操作之间被挂起
        Thread.sleep(300);
    }

    private void stepTwo(int val) {
        secondVal = val;
    }

    private void suspendRequest() {
        this.suspended = true;
    }

    private void resumeRequest() {
        this.suspended = false;
    }

    private void waitWhileSuspended() throws InterruptedException {
        // “繁忙等待”技术的示例
        // 它是非等待条件改变的最佳途径，因为它会不断请求处理器周期地执行检查
        // 更佳的技术是：使用Java内置“通知-等待”机制
        while (this.suspended) {
            Thread.sleep(200);
        }
    }
}
