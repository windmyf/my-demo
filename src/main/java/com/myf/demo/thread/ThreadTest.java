package com.myf.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author windmyf
 * @date 2020/9/16 15:07
 * @desc 线程测试类
 */
public class ThreadTest {

    public static void main(String[] args) {
        /**
         *   MyThread myThread = new MyThread();
         *   myThread.start();
         *   System.out.println(Thread.currentThread().getName() + "main()方法执行结束");
         */

        /**
         *  MyRunnable myRunnable = new MyRunnable();
         *         Thread thread = new Thread(myRunnable);
         *         thread.start();
         *         System.out.println(Thread.currentThread().getName()+" main()方法执行完成");
         */

        /**
         * FutureTask<Integer> futureTask = new FutureTask<>(new MyCallable());
         *         Thread thread = new Thread(futureTask);
         *         thread.start();
         *
         *         try {
         *             Thread.sleep(1000);
         *             System.out.println("返回结果" + futureTask.get());
         *         } catch (Exception e) {
         *             e.printStackTrace();
         *         }
         *
         *         System.out.println(Thread.currentThread().getName() + " main()方法执行完成");
         */

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        MyRunnable myRunnable = new MyRunnable("");
        for (int i = 0; i < 5; i++) {
            executorService.execute(myRunnable);
        }
        System.out.println("线程任务开始执行");
        executorService.shutdown();
    }
}
