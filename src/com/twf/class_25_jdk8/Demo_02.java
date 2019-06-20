package com.twf.class_25_jdk8;

/**
 * @ClassName:Demo_02
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1714:55
 * @Version:1.0 •Lamda属于函数式编程的概念；目的是为了 简化匿名内部类 的写法
 * •Lamda表达式语法的三种形式
 * (参数) -> 单行语句;
 * • (参数) -> {多行行语句};
 * • (参数) -> 表达式;
 * • 如果无参数就可以写成   • () -> 单行语句;
 **/
@FunctionalInterface//函数式接口
interface IPrintInter {//接口

    //无参数
    // public void print();
    //带参数
//    public void show(String val);
    // public void show2(int a, int b);
    public abstract int show2(int a, int b);

    default void prints() {
    }

    static void prints2() {
    }
}

public class Demo_02 {
    static int sum = 10;
    public static void main(String[] args) {
        //原来的：匿名(anonymous)内部类的使用
//        fun(new IPrintInter() {
//            @Override
//            public void print() {
//                System.out.println("原来的：匿名内部类的使用");
//            }
//            @Override
//            public void show(String val) {
//                System.out.println("带参数的 "+val);
//            }
//        });

        //JDK8  Lamda表达式 无参数单条语句 的语法
        // fun(()->System.out.println("JDK8  Lamda表达式语法"));

        //带一个参数
//        fun2((s)->{ //带参数可以写多行
//            System.out.println(s);
//        });
        //带一个参数单行
//        fun2((s)-> System.out.println(s));

        //带多个参数
//        fun3((a, b) -> {
//            int c  = a+b;
//            System.out.println(a + b);
//        });
//        IPrintInter  s= (int a,int b) ->{
//            int c  = a+b;
//            System.out.println(a + b);
//        };
        final int age = 10; //匿名内部类中 局部变量为final
        IPrintInter s = (a, b) ->
//            int c  = a+b;
//            return  c;
        {
            System.out.println(age);
            System.out.println(sum);
            return a + b;
        } ; //一条语句时 大括号、return省略

        System.out.println(s.show2(22, 22));
    }

    //    private static void fun(IPrintInter p) {
//        p.print();//接口回调
//    }
//    private static void fun2(IPrintInter p2) {
//        p2.show("张三");//接口回调
//    }
//    private static void fun3(IPrintInter p) {
//        p.show2(11, 22);//接口回调
//    }

}
