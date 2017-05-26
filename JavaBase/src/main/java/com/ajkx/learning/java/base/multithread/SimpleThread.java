package com.ajkx.learning.java.base.multithread;

/**
 * Created by ajkx
 * Date: 2017/5/24.
 * Time:16:40
 */

/**
 * desc: 继承Thread类来创建线程类
 * step:
 *  1.定义Thread类的子类，重写run方法，该run()方法体即时线程执行体
 *  2.创建Thread对象，并调用start()启用线程
 *
 * tips:
 *  Thread.currentThread()方法是Thread类的静态方法，用于获取当前正在执行线程,getName()为获取线程名称
 *
 * weakness:
 *  使用该方法创建线程类时，多个线程间无法共享线程类的实例变量
 */
public class SimpleThread extends Thread{

    public int i;

    @Override
    public void run() {
        for(;i < 100; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                new SimpleThread().start();
                new SimpleThread().start();
            }
        }
    }
}
