package com.twf.class_24;

/**
 * @ClassName:Demo_14
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1621:22
 * @Version:1.0
 **/
public class Demo_14 {
    static boolean foo(char c) {
        System.out.print(c);
        return  true;
    }

    /**
     * a
     * b
     * d
     * c
     *
     * b
     * d
     * c
     *
     * b
     *
     * @param args
     */
    public static void main(String[] args) {
        int i = 0;
        for (foo('A'); foo('B') && (i < 2); foo('C')) {
            i++;
            foo('D');
        }
    }

}
