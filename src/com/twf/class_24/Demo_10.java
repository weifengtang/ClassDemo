package com.twf.class_24;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @ClassName:Demo_10
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1620:35
 * @Version:1.0
 **/
public class Demo_10 {

    private Date birthDate = new Date();
    Calendar cal = null;
    Date boomStart = null;
    Date boomEnd = null;
    int a ,b =0;
    boolean f;
    // 判断是否是某个阶段人
    public boolean isBabyBoomer() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT")); // 开始时间
        cal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = cal.getTime();//创建Date对象

        cal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);// 结束时间
        Date boomEnd = cal.getTime();//创建Date对象
        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
    }

    // 判断是否是某个阶段人
    public boolean isBabyBoomer2() {
        cal  = Calendar.getInstance(TimeZone.getTimeZone("GMT")); // 开始时间
        cal.set(1946,Calendar.JANUARY, 1, 0, 0, 0);
        boomStart = cal.getTime();//创建Date对象
        cal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);// 结束时间
        boomEnd = cal.getTime();//创建Date对象
        a = birthDate.compareTo(boomStart); //大于等于
        b = birthDate.compareTo(boomEnd);// 小于
        f =  a >= 0 && b < 0; // 0 1   - 1
        return f;
    }

    public static void main(String[] args) {
        Demo_10 demo_10 = new Demo_10();

        Long startTime = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
           // System.out.println(demo_10.isBabyBoomer()); //2725166135
            System.out.println(demo_10.isBabyBoomer2()); //2043213741   1834525608  1646974068
        }

        Long endTime = System.nanoTime();
        System.out.println("消耗时间：" + (endTime - startTime) +" ms");

    }
}
