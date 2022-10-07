package com.java.chapter08.day01.java;

/**
 * TODO 线程中常见的方法
 * Created by tom on 2022/10/6
 */


/*
 * 测试Thread中的常用方法：
 * 1. start():启动当前线程；调用当前线程的run()
 * 2. run(): 通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3. currentThread():静态方法，返回执行当前代码的线程
 * 4. getName():获取当前线程的名字
 * 5. setName():设置当前线程的名字
 * 6. yield():释放当前cpu的执行权
 * 7. join():在线程a中调用线程b的join(),此时线程a就进入阻塞状态，直到线程b完全执行完以后，线程a才
 *           结束阻塞状态。
 * 8. stop():已过时。当执行此方法时，强制结束当前线程。
 * 9. sleep(long millitime):让当前线程“睡眠”指定的millitime毫秒。在指定的millitime毫秒时间内，当前
 *                          线程是阻塞状态。
 * 10. isAlive():判断当前线程是否存活
 *
 *
 * 线程的优先级：
 * 1.
 * MAX_PRIORITY：10
 * MIN _PRIORITY：1
 * NORM_PRIORITY：5  -->默认优先级
 * 2.如何获取和设置当前线程的优先级：
 *   getPriority():获取线程的优先级
 *   setPriority(int p):设置线程的优先级
 *
 *   说明：高优先级的线程要抢占低优先级线程cpu的执行权。但是只是从概率上讲，高优先级的线程高概率的情况下
 *   被执行。并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行。
 *
 */

public class ThreadMethodTest {

    public static void main(String[] args) {

        MethodThread t1 = new MethodThread();


        // 设置线程名
        t1.setName("线程一");

        // 设置线程优先级
        t1.setPriority(Thread.MIN_PRIORITY);

        // 启动当前线程
        t1.start();


        // main线程
        Thread.currentThread().setName("主线程");
        // 设置主线程优先级
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        for(int i = 0;i <= 100;i++){
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + " :"  + Thread.currentThread().getPriority()  + ": "+ i);

//                try {
//                    t1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }

        System.out.println(t1.isAlive());


    }

}


class MethodThread extends Thread {

    @Override
    public void run() {

        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {

                // 获取当前对象：Thread.currentThread()
                // getName()： 获取进程名
                System.out.println(Thread.currentThread().getName() + ": " + getPriority() + " : " + i);
            }

            if(i % 20 == 0){
                // 释放当前cpu的执行权
//                yield();
//
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }

    }
}
