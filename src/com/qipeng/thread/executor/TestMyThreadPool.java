package com.qipeng.thread.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/22 14:48
 */
public class TestMyThreadPool {

    public static void main(String[] args) {
        // 创建等待队列
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(20);
        // 创建线程池，池中保存的线程数为3，允许的最大线程数为5
        // corePoolSize：线程中所保存的核心线程数，保存空闲线程
        // maximumPoolSize：池中允许的最大线程数
        // keepAliveTime：线程池中的空闲线程所能持续的最长时间
        // unit：持续时间的单位
        // workQueue：任务执行前保存任务的队列，仅保存execute方法提交的Runnable任务
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 10, TimeUnit.MILLISECONDS, blockingQueue);

        // 创建7个任务
        MyTask task1 = new MyTask();
        MyTask task2 = new MyTask();
        MyTask task3 = new MyTask();
        MyTask task4 = new MyTask();
        MyTask task5 = new MyTask();
        MyTask task6 = new MyTask();
        MyTask task7 = new MyTask();

        // 每个任务会在一个线程上执行
        pool.execute(task1);
        pool.execute(task2);
        pool.execute(task3);
        pool.execute(task4);
        pool.execute(task5);
        pool.execute(task6);
        pool.execute(task7);

        // 关闭线程池
        pool.shutdown();
    }
}
