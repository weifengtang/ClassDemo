package com.twf.class_23;

/**
 * @ClassName:Demo_03
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1411:08
 * @Version:1.0
 * Java实现求一个整数的二进制数中1的个数
 *
 **/
public class Demo_03 {
    public static void main(String[] args) {
        Integer number = 31;
        String binaryString = Integer.toBinaryString(number);

        System.out.println(Integer.bitCount(number));
        System.out.println("二进制："+binaryString);

        //求一个整数的二进制数中1的个数
        int count = 0;
        while(number!= 0)
        {
            /**count: 1,2，3
             * number: 111&110=110  110&101=100 100&011 =0
             */
            count++;
            number=number&(number-1);
        }
        System.out.println(count);

}
}
