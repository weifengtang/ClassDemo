package com.twf.class_25_jdk8;

/**
 * @ClassName:Demo_01
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1714:51
 * @Version:1.0
 *
 * JDK8新特性
 * •接口里可以有默认方法实现
 *  •Lambda表达式：  函数式编程概念，简化匿名内部类写法
 *  •方法引用:   定义别名
 * •内置函数式接口
 *  •Streams和Map
 * •时间日期API
 *  •Annotations 注解
 **/


public class Demo_01 implements Inter {
    @Override
    public void fun() {

    }

    @Override
    public void fun2() {

    }

    public static void main(String[] args) {
        Inter.fun3();
    }
}

//接口里可以有默认方法实现
interface Inter{
    public abstract void fun();

    public default void fun2(){
        System.out.println("接口中default 默认实现");
    }
    public static void fun3(){
        System.out.println(" 接口中static默认实现");
    }

}