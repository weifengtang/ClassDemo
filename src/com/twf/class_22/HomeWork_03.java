package com.twf.class_22;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName:HomeWork_03
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1217:22
 * @Version:1.0
 *
 * •创建代理类 PersonProxy,PersonProxy的在
 * 代理Person类的所有setter方法时,把方法的 调用时间、方法名称写入到文本文件中,每一 行日志的格式为：
 * • 时间：2012-09-01 23：34：24;方法名称： setName;参数：张无忌
 *
 **/

public class HomeWork_03 {

    public static void main(String[] args) {

        IPerson person =new Person();

        MyHandler myHandler = new MyHandler(person);

        IPerson iPerson = (IPerson) Proxy.newProxyInstance(IPerson.class.getClassLoader(),person.getClass().getInterfaces(),myHandler);
        iPerson.print();

    }

}
class MyHandler implements InvocationHandler{
    private Object object;

    MyHandler(Object o){
      this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行前----");
        Object ob =  method.invoke(this.object,args);
        System.out.println("执行后----");
        return ob;
    }
}