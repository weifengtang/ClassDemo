package com.twf.class_25_jdk8;

/**
 * @ClassName:Demo_03
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1715:21
 * @Version:1.0 •引用静态方法: 类名::static 方法名;
 * •引用某个对象的方法: 对象实例::普通方法名;
 * •引用特定类型的方法: 特定类名::普通方法名;
 * •引用构造方法: 类名::new;
 * •如果要实现方法引用,需要定义一个接口,该接口中只能有一 个方法
 **/

import com.twf.class_10.Person;

/**
 * 引用静态方法示例
 * /** * 实现方法的引用接口
 * * @param <T> 引用方法的参数类型
 * * @param <R> 引用方法的返回值类型
 */
interface IFunction<T, R> {
    public R apply(T t);
}

//引用某个对象的普通方法 示例
interface IFunction2<R> {
    public R upper();
}

//引用特定类型的方法
interface IFunction3<T> {
    public int compare(T t1, T t2);
}

//引用构造方法 示例
interface IFunction4<R> {
    public R create(String titile, double price);
}
//引用构造方法 示例二
interface IFunction5 {
    public Book create(String titile, double price);
}

class Book {
    private String titile;
    private double price;

    public Book(String titile, double price) {
        this.titile = titile;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [titile=" + titile + ", price=" + price + "]";
    }
}

public class Demo_03 {

    public static void main(String[] args) {
        //1、引用静态方法
        IFunction<Integer, String>
               function = String::valueOf;
        String str = function.apply(1000);
        System.out.println("引用静态方法" + str);

        //2、引用某个对象的普通方法
        IFunction2<String> function1 = "hello"::toUpperCase;
        String str2 = function1.upper();
        System.out.println("引用某个对象的普通方法" + str2);

        //3、引用特定类型的方法
        IFunction3<String> fun = String::compareTo;
        //方法引用前不需要定义对象,而是将对象定义在了方法上
        System.out.println(fun.compare("A", "C"));

//            引用构造方法 示例
        //IFunction4<Book> fun2 = Book::new;
        IFunction5 fun2 = (t,p)-> new Book(t,p);
        IFunction5 fun3 = Book::new;
        System.out.println(fun2.create("www3",22d));
        System.out.println(fun3.create("www3",22d));

       // Book book = fun.create("Java编程思想", 89.5);
       // System.out.println(book);

    }
}
