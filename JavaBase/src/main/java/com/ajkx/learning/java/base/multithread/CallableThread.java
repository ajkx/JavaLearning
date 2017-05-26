package com.ajkx.learning.java.base.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by ajkx
 * Date: 2017/5/25.
 * Time:15:22
 */

/**
 * desc: 实现Callable接口来创建线程类
 * step:
 *  1.创建Callable接口实现类，实现Call方法
 *  1.创建FutureTask对象来包装Callable对象，通过FutureTask对象封装Callable的Call方法
 *  2.创建Thread对象，并通过new Thread(targer,name)创建子线程 调用start()启用线程
 *
 * tips:
 *
 * weakness:
 */
public class CallableThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableThread callableThread = new CallableThread();

        FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>)() ->{
            int i = 0;
            for(;i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            return i;
        });

        for(int i = 0;i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if(i == 20){
                new Thread(task,"aa").start();
            }
        }

        System.out.println(task.get());
    }
}
