package com.twf.class_24;

/**
 * @ClassName:Demo_11
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1620:59
 * @Version:1.0
 **/
public class Demo_11 {

    public static void main(String[] args) {

        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        //引用传递
        operate(a, b);
        System.out.println(a + "," + b);
    }

    private static void operate(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }

}
