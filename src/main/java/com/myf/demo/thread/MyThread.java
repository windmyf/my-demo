package com.myf.demo.thread;
/**
 * @author windmyf
 * @date 2020/9/16 15:02
 * @desc 创建线程----继承Thread类
 * 步骤：1、定义一个Thread子类，重写run方法，将相关逻辑实现，run()方法就是线程要执行的业务逻辑方法
 *      2、创建自定义的线程子类对象
 *      3、调用子类实例的start()方法来启动线程
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "run()方法正在执行。。。。");
    }

}
