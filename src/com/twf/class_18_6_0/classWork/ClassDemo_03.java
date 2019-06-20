package com.twf.class_18_6_0.classWork;


/**
 * @ClassName:ClassDemo_03
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/516:45
 * @Version:1.0 使用两个线程打印 1-1000. 线程1, 线程2 交 替打印
 **/
public class ClassDemo_03 {
    public static void main(String[] args) throws InterruptedException {
        MyPrint myPrint = new MyPrint();
        Thread t1 = new Thread(myPrint);
        Thread t2 = new Thread(myPrint);
        Thread t3 = new Thread(myPrint);
        t1.setName("0");
        t2.setName("1");
        t3.setName("2");
        t1.start();
        t2.start();
        t3.start();

    }
}

//方式一： 1，2，3%3  1，2，0
class MyPrint implements Runnable {
    private int num = 1;
    @Override
    public void run() {
        int threadNumber = Integer.parseInt(Thread.currentThread().getName()) ;
        while (true) {
            synchronized (this) {
                if (num > 1000) {
                    break;
                }
                if(num%3==threadNumber) {
                    System.out.println("Thread_" + Thread.currentThread().getName() + "-" + num);
                    num++;
                }

            }
        }
    }

}

/////////////////////////////////////////////////////////////////////////////////
/**
 * 实现方式二；A线程打印奇数，B线程打印偶数
 */
class ThreadAB1 {
    static int count=0;
    Thread A = new Thread(new Runnable() {
        public void run() {
            for (int i = 1; i < 1000; i += 2) {
                print("线程：A --" + i);
                count++;
            }
        }
    });
    Thread B = new Thread(new Runnable() {
        public void run() {
            for (int i = 2; i <= 1000; i += 2) {
                print("线程：B --" + i);
                count++;
            }
        }
    });

    private synchronized void print(String str) {
        notify();
        System.out.println(str);
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadAB1 instance = new ThreadAB1();
        instance.A.start();
        instance.B.start();


        System.out.println(1%3);
        System.out.println(2%3);
        System.out.println(3%3);
    }
}



/***************************************************************************************
 * 实现方式三；
 */

 class ThreadAB2 {
    private static Object LOCK = new Object();
    private static boolean flag = false;

    public static void main(String[] args) {
        Thread A = new Thread() {
            public void run() {
                for (int i = 1; i < 100; i += 2) {
                    synchronized (LOCK) {
                        System.out.println("A " + i);
                        if (!flag) {
                            flag = true;
                            LOCK.notify();// 在这里虽然唤醒了另一个线程b，但锁并没有释放
                            if (i < 100) {
                                try {
                                    LOCK.wait();// 在wait后的瞬间线程b得到锁
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        };

        Thread B = new Thread() {
            public void run() {
                for (int i = 2; i <= 100; i += 2) {
                    synchronized (LOCK) {
                        System.out.println("B " + i);
                        if (flag) {
                            flag = false;
                            LOCK.notify();
                            if (i < 100) {
                                try {
                                    LOCK.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        };

        A.start();
        B.start();
    }
}
