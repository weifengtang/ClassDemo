package com.twf.class_24;

/**
 * @ClassName:Demo_02
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1417:31
 * @Version:1.0
 **/
public class Demo_02 {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person f = new Person("小头爸爸");// 定义父亲
        Person s1 = new Person("大儿子", f);// 定义大儿子 // 小儿子的信息是通过大儿子拷贝过来的
        int a = 8/-1;
        int b = -8/0;
        System.out.println(a+" "+b);
        Person s2 = (Person)s1.clone();
        s2.setName("小儿子"); //认干爹
        s1.getFather().setName("干爹");
        System.out.println(s1.getName() + "的父亲是 " + s1.getFather().getName());
        System.out.println(s2.getName() + "的父亲是 " + s2.getFather().getName());
    }
    }
