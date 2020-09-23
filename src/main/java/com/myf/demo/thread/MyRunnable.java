package com.myf.demo.thread;

import java.util.Date;

/**
 * @author windmyf
 * @date 2020/9/16 15:10
 * @desc 创建线程----实现Runnable接口
 * 步骤：1、定义Runnable接口实现类MyRunnable，并充写run()方法
 *      2、创建MyRunnable实例myRunnable，以myRunnable作为target创建Thread对象
 *          该Thread对象才是真正的线程对象
*       3、调用线程对象的start()方法
 */
public class MyRunnable implements Runnable{

    private String command;

    public MyRunnable(String s){
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start.time = "+new Date());

        processCommand();

        System.out.println( Thread.currentThread().getName()+" End.time = " + new Date());
    }

    private void processCommand(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }
}
