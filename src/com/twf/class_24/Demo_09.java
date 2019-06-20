package com.twf.class_24;

/**
 * @ClassName:Demo_09
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1620:30
 * @Version:1.0
 **/
public class Demo_09 {
    /**
     *
     * JVM中当前类得Class仅此一个
     * static 属性也是仅此一份，不会在实例中创建，直接调用类中static属性及方法即可
     */
    private static int x = 100;

    public static void main(String[] args) {
        Demo_09 hs1 = new Demo_09();
        hs1.x++; //x=101
        Demo_09 hs2 = new Demo_09();
        hs2.x++;//x=102
        hs1 = new Demo_09();
        hs1.x++;//x=103
        Demo_09.x++; // 104
        System.out.println("X:" + x);
    }
}
