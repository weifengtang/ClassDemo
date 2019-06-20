package com.twf.class_22;

import java.lang.reflect.Method;

/**
 * @ClassName:HomeWork_01
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1216:38
 * @Version:1.0 在Person类中定义一个可变参数方法(通过循环打 印输出传入的参数)
 * •需要将传入的参数通过反射创建数组对象传入该方法执行。
 * •在测试类中 通过反射执行可变参数方法
 * •传入一个参数 (动态创建数组类型)
 * •传入多个参数 (动态创建数组类型)
 **/
public class HomeWork_02 {

    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.twf.class_22.Person");
        Object object = clazz.newInstance();
        Method method = clazz.getMethod("print", Integer[].class);

        Integer[] o = new Integer[]{1, 2, 3, 4};
        method.invoke(object,(Object) o); //只能传入Object类型
    }
}
class Person implements  IPerson{
    //可变参数方法(通过循环打 印输出传入的参数)
    public void print(Integer... objects) {
        for (Object o : objects) {
            System.out.println(o);
        }
    }
}
interface  IPerson{
    public void print(Integer... objects);
}