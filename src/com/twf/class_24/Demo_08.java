package com.twf.class_24;

/**
 * @ClassName:Demo_08
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1620:26
 * @Version:1.0
 **/
public class Demo_08 {
    public static void main(String[] args) {
        System.out.println(findResult()); //true->false
    }

    /**
     *
     * @return
     */
    private static boolean findResult() {
        try {
            return true;
        } catch (Exception e) {
            return true;
        } finally {
            return false;
        }
    }
}
