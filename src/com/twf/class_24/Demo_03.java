package com.twf.class_24;

/**
 * @ClassName:Demo_03
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1610:44
 * @Version:1.0
 **/

class ValHold{ public int  i = 0;}
public class Demo_03 {

    public static void main(String[] args) {
        Demo_03 demo_03 = new Demo_03();
        demo_03.method();
    }

    public  void method(){
        int i  =  99;
        ValHold v = new ValHold();
        v.i = 30;
        method(v,i);
        System.out.println("3、 "+v.i); //20
    }
    // 形参传递时的 对象引用
    private void method(ValHold v, int i) {
        i = 0;
        v.i = 20;
        ValHold vh = new ValHold();
        v = vh ;
        System.out.println("1、 "+v.i);//0
        System.out.println("2、"+i); //0

    }

}
