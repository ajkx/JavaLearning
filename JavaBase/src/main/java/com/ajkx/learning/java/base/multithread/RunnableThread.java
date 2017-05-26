package com.ajkx.learning.java.base.multithread;

/**
 * Created by ajkx
 * Date: 2017/5/24.
 * Time:17:00
 */

/**
 * desc: 实现Runable接口来创建线程类
 * step:
 *  1.实现Runnable接口，重写run方法，该run()方法体即时线程执行体
 *  2.创建Thread对象，并通过new Thread(targer,name)创建子线程 调用start()启用线程
 *
 * tips:
 *
 * weakness:
 */

public class RunnableThread implements Runnable{
    public int i;
    @Override
    public void run() {
        for(;i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                RunnableThread st = new RunnableThread();
                new Thread(st,"Thread1").start();
                new Thread(st,"Thread2").start();
            }
        }
    }
}
