package com.myf.demo.thread;

import java.util.concurrent.Callable;

/**
 * @author windmyf
 * @date 2020/9/16 15:16
 * @desc 创建线程----实现Callable接口
 * 步骤：1、创建实现Callable接口的实现类MyCallable
 *      2、以myCallable为参数创建FutureTask对象
 *      3、将FutureTask作为参数创建Thread的对象
 *      4、调用线程对象的start()方法
 */
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" call()方法执行中。。。。");
        return 1;
    }
}
