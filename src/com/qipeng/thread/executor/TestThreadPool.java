package com.qipeng.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/21 17:24
 */
public class TestThreadPool {

    public static void main(String[] args) {
        // 缓存型池，先查看池中有没有以前建立的线程，如果有就reuse，反之就创建一个新的线程
        // 通常用于执行一些生存期很短的异步型任务，因此在一些面向连接的daemon型和server中用的不多
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 创建固定数目线程的线程池，创建原则同缓存型类似
        // 任意时间点，最多只能有固定数目的活动线程存在
        // ExecutorService executorService = Executors.newFixedThreadPool(int);

        // 调度型线程池
        // 该池的线程可以按schedule依次延迟（delay）执行，或周期执行
        // ExecutorService executorService = Executors.newScheduledThreadPool();

        // 单例线程，任意时间池中只能有一个线程
        // ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            // execute 会首先在线程池中选择一个已有空闲线程来执行任务
            // 如果线程池中没有空闲线程，它便会创建一个新的线程来执行任务
            executorService.execute(new Task());
            System.out.println("************* " + i + " ************");
        }

        executorService.shutdown();
    }
}
