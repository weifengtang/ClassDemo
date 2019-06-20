package com.twf.class_18_6_0.classWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName:ClassDemo_04
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/516:58
 * @Version:1.0 某公司组织年会, 会议入场时有两个入口,
 * 在入场时每位员工都能获取一张 双色球彩票(彩票号码通过Random类随机生成),
 * 假设公司有100个员工, 利用多线程模拟年会入场过程,
 * • 并分别统计每个入口入场的人数,以及每个员工拿到的彩票的号码。线程 运行后打印格式如下：
 * • 编号为: 2 的员工 从后门 入场! 拿到的双色球彩票号码是: [17, 24, 29, 30, 31, 32, 07]
 * • 编号为: 1 的员工 从后门 入场! 拿到的双色球彩票号码是: [06, 11, 14, 22, 29, 32, 15]
 * • //.....
 * • 从后门入场的员工总共: 13 位员工 • 从前门入场的员工总共: 87
 **/
public class ClassDemo_04 {

    public static void main(String[] args) {
        MyThread e = new MyThread();
        Thread t0 = new Thread(e, "前门");
        Thread t1 = new Thread(e, "后门");

        t0.start();
        t1.start();

    }

}

class MyThread implements Runnable {
    int frontNum = 0;
    int backNum = 0;
    int person = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                String ThreadName = Thread.currentThread().getName();
                if (person < 0) {
                    return;
                }
                if (person > 0) {
                    if (ThreadName.equals("前门")) {
                        frontNum++;
                        System.out.print("编号为" + (100 - person + 1) + "的员工 从" + ThreadName + " 入场，拿到的双色球彩票号码是:");
                        person--;
                        getNum();
                    }
                    if (ThreadName.equals("后门")) {
                        backNum++;
                        System.out.print("编号为" + (100 - person + 1) + "的员工 从" + ThreadName + "入场，拿到的双色球彩票号码是:");
                        person--;
                        getNum();
                    }
                }
                if (person == 0) {
                    System.out.println("从前门入场的员工总共: " + frontNum + "位员工");
                    System.out.println("从后门入场的员工总共: " + backNum + "位员工");
                    person--;
                }
            }
        }

    }

    public void getNum() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 7; i++) {
            Random r = new Random();
            int num = r.nextInt(30) + 1;
            if (list.contains(num)) {
                num = r.nextInt(30) + 1;
            }
            list.add(num);
        }
        System.out.println(list);
    }

}
