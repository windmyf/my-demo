package com.myf.demo.thread;
/**
 * @author windmyf
 * @date 2020/9/23 13:50
 * @desc ThreadLocal测试类
 */
public class TestThreadLocal {

    // 线程本地存储变量
    private static ThreadLocal<Integer> THREAD_LOCAL_NUM = new ThreadLocal<Integer>(){

        @Override
        protected  Integer initialValue(){
            return 0;
        }
    };


    public static void main(String[] args) {
        // 启动三个线程
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    add10ByThreadLocal();
                }
            };
            thread.start();
        }
    }

    /**
     * 本地存储变量加5
     */
    private static void add10ByThreadLocal(){
        for (int i = 0; i < 5; i++) {
            Integer n = THREAD_LOCAL_NUM.get();
            n += 1;
            THREAD_LOCAL_NUM.set(n);

            System.out.println(Thread.currentThread().getName()+": ThreadLocal num = " + n);
        }
    }
}
