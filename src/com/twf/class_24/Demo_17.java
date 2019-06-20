package com.twf.class_24;

/**
 * @ClassName:Demo_17
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1622:32
 * @Version:1.0
 **/

/**当用final作用于类的成员变量时，成员变量
 * （注意是类的成员变量，局部变量只需要保证在使用之前被初始化赋值即可）必须在定义时或者构造器中进行初始化赋值，
 * 而且final变量一旦被初始化赋值之后，就不能再被赋值了
 *
 * 类的final变量；引用变量被final修饰之后，虽然不能再指向其他对象，指向的对象的内容是可变的。
 * 修饰属性：
 * static作用于成员变量用来表示只保存一份副本，
 * 而final的作用是用来保证变量不可变。
 *
 */
public class Demo_17 {
    public static void main(String[] args)  {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        System.out.println(myClass1.i);
        System.out.println("j= "+myClass1.j);
        System.out.println(myClass2.i);
        System.out.println("j= "+myClass2.j);

    }
}

class MyClass {
    public final double i = Math.random();
    public static double j = Math.random();
}