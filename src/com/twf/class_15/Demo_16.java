package com.twf.class_15;

/**
 * @ClassName:Demo_16
 * @Description TODO
 * @Author:TWF
 * @Date:2019/5/3121:08
 * @Version:1.0
 **/
public class Demo_16 {
}

class Amail implements  Comparable{

    @Override
    public int compareTo(Object o) {
        System.out.println("----Amail");
        return 0;
    }
}
class Pig extends Amail implements Comparable{

    @Override
    public int compareTo(Object o) {
        return 1;
    }
}