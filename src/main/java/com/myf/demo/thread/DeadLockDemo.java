package com.myf.demo.thread;

/**
 * @author windmyf
 * @date 2020/9/23 14:22
 * @desc 死锁示例
 */
public class DeadLockDemo {
    /**
     * 资源1
     */
    private static Object resource1 = new Object();
    /**
     * 资源2
     */
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + " get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread() + " waiting get resource2 ");

                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + " get resource2");
                }
            }
        }, "线程1").start();

        new Thread(() -> {

            /**
             * 会造成死锁代码
             *  synchronized (resource2) {
             *                 System.out.println(Thread.currentThread() + " resource2");
             *
             *                 try {
             *                     Thread.sleep(1000);
             *                 } catch (InterruptedException e) {
             *                     e.printStackTrace();
             *                 }
             *
             *                 System.out.println(Thread.currentThread() + " waiting get resource1");
             *
             *                 synchronized (resource1) {
             *                     System.out.println(Thread.currentThread() + " get resource1");
             *                 }
             *             }
             */
            /**
             * 避免死锁代码
             */
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + " get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread() + " waiting get resource2 ");

                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + " get resource2");
                }

            }
        }, "线程2").start();
    }
}
