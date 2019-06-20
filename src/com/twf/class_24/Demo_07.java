package com.twf.class_24;

/**
 * @ClassName:Demo_07
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1620:21
 * @Version:1.0
 **/
public class Demo_07 {
    static final int END = Integer.MAX_VALUE;  //2147483647
    static final int START = END - 100; //2147483547

    public static void main(String[] args) {
        int count = 0;

        System.out.println("END:"+END);
        System.out.println("START:"+START);

        //for (int i = START; i <= END; i++) { //i <= END永远都小于 int的最大值
        for (int i = START; i <=2147483600 ; i++) {

            count++;
        }
        System.out.println(count);
    }
}
