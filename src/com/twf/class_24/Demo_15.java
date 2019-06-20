package com.twf.class_24;

import java.math.BigInteger;

/**
 * @ClassName:Demo_15
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1621:36
 * @Version:1.0
 **/
public class Demo_15 {
    /**
     * BigInteger 不可变的任意精度的整数。
     * BigInteger实例是不可变的，
     * 此外String、BigDecimal以及包装类型：Integer、Long、Short、Byte、Character、Boolean、Float和Double都是不可变类，
     * 即不能修改它们实例的值，对这些不可变类型的操作将返回新的实例。
     *
     * @param args
     */
    public static void main(String[] args) {
        BigInteger fiveThousand = new BigInteger("5000");
        BigInteger fiftyThousand = new BigInteger("50000");
        BigInteger fiveHundredThousand = new BigInteger("500000");
        // public static final BigInteger ZERO = new BigInteger(new int[0], 0); 静态的终态的
        BigInteger total = BigInteger.ZERO;
        // BigInteger total = new BigInteger("10",2);
        //  total.add(fiveThousand);           total.add(fiftyThousand);           total.add(fiveHundredThousand);
        total = total.add(fiveThousand);
        total = total.add(fiftyThousand);
        total = total.add(fiveHundredThousand);
        System.out.println(total);

        /**
         * 如以下写法：得不到想要的211
         */
        Integer a = 111;
        addInteger(a,100); //111
        //a = addInteger(a,100); //211
        System.out.println(a);
    }
    private static Integer addInteger(Integer a,Integer b){
        return  a+b;
    }

}
