package com.twf.class_18_6_0.classWork;

/**
 * @ClassName:ClassDemo_00
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/516:30
 * @Version:1.0
 **/

class MyTicket implements Runnable { // 实现Runnable接口
    private  int ticket = 5; // 一共5张票

    public void run() { // 重写run()方法
        for (int i = 0; i < 100; i++) { // 超出票数的循环
           synchronized (MyTicket.class) {
               if (ticket > 0) { // 判断是否有剩余票
                   System.out.println("卖票：ticket=" + ticket--);
               }
           }
        }
    }
};

public class ClassDemo_00 {
    public static void main(String args[]) {
        MyTicket my = new MyTicket();
        new Thread(my).start(); // 启动三个线程
        new Thread(my).start(); // 启动三个线程
        new Thread(my).start(); // 启动三个线程
    }
};