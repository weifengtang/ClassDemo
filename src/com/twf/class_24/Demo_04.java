package com.twf.class_24;

import java.util.List;

/**
 * @ClassName:Demo_04
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1610:55
 * @Version:1.0
 * 1、无边界的通配符(Unbounded Wildcards), 就是<?>, 比如List<?>.
 * 　　无边界的通配符的主要作用就是让泛型能够接受未知类型的数据.
 * 2. 固定上边界的通配符(Upper Bounded Wildcards):
 * 　　使用固定上边界的通配符的泛型, 就能够接受指定类及其子类类型的数据. 要声明使用该类通配符,
 *      采用<? extends E>的形式, 这里的E就是该泛型的上边界. 注意: 这里虽然用的是extends关键字,
 *      却不仅限于继承了父类E的子类, 也可以代指显现了接口E的类.
 * 3. 固定下边界的通配符(Lower Bounded Wildcards):
 * 　　使用固定下边界的通配符的泛型, 就能够接受指定类及其父类类型的数据. 要声明使用该类通配符,
 *      采用<? super E>的形式, 这里的E就是该泛型的下边界. 注意: 你可以为一个泛型指定上边界或下边界,
 *      但是不能同时指定上下边界.
 **/
public class Demo_04 {

    public static <E> void read(List<? extends E> list) {
        int sum = 0;
        Object i = list.get(2);

    }  public static <E> void read2(List<? extends Number> list) {
        //Number的子类 AtomicInteger, AtomicLong, BigDecimal, BigInteger, Byte, Double, Float, Integer, Long, Short
        int sum = 0;
        Object i = list.get(2);
        Integer a =(Integer) list.get(2);
        Double b =(Double) list.get(2);
       // char c =(char) list.get(2);
    }

    public static void write(List<? super Number> list) { // 加入一个元素
        list.add(123);
     //   list.add("");
        list.add(1.1);
        list.add(null);
        Number s  = (Number) list.get(2);
        Object ss  = (Object) list.get(2);

    }

}
