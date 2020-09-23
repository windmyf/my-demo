package com.myf.demo.thread;

/**
 * @author windmyf
 * @date 2020/9/23 14:01
 * @desc 单例
 */
public class SingleTon {

    private static volatile SingleTon singleTon = null;

    private SingleTon(){}

    public static SingleTon getInstance(){

        if (singleTon==null){
            synchronized (SingleTon.class){
                if (singleTon==null){
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}
