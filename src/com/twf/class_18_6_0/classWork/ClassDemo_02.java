package com.twf.class_18_6_0.classWork;

/**
 * @ClassName:ClassDemo_02
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/516:07
 * @Version:1.0
 * •需求：设计一个线程操作类,要求可以产生三个线程对象,并 可以分别设置三个线程的休眠时间,
 * 如下所示： • 线程A,休眠10秒 • 线程B,休眠20秒 • 线程C,休眠30秒 •问：此类该如何设计？
 *线程名称和休眠时间
 *
 **/
public class ClassDemo_02 {

    public static void main(String[] args) {
        ThreadManager a = new ThreadManager("A",1000L);//1s
        ThreadManager b = new ThreadManager("B",5000L); //5s
        ThreadManager c = new ThreadManager("C",10000L);//10s

        a.start();
        b.start();
        c.start();

    }


}

//线程管理类
class ThreadManager extends Thread{

    private String threadName; //线程名称
    private Long sleepTime;//休眠时间

    public ThreadManager(String threadName, Long sleepTime) {
        super(threadName);
       // this.threadName = threadName;
        this.sleepTime = sleepTime;
    }


    @Override
    public void run() { // 重写Thread类中的run()方法
        try {
           // Thread.currentThread().setName(threadName);
            Thread.currentThread().sleep(sleepTime);
            System.out.println(Thread.currentThread().getName()+"-");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}