package com.twf.class_23;

import java.lang.annotation.Inherited;
import java.lang.reflect.*;
import java.util.ArrayList;

/**
 * @ClassName:HomeWork_02
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1314:40
 * @Version:1.0 自定义注解@NotNull,该注解使用在方法级别上，
 * 在执行方法前使用反射获得方法上的注解，并检查 传递到方法上的参数是否为空，
 * 如果为空根据类型 给一个默认值 •示例:
 * • @NotNull(name,order("key","value"),request("key","value"))
 * • public void XXX(String name,String order,String request){
 * • } •如果传递的order或request为null,则去对应的key 中的value
 **/
public class HomeWork_02 {

    public static void main(String[] args) {
        HomeWork_02 homeWork_02 = new HomeWork_02();

        IDemo iDemo = new Demo();
        IDemo demo = (IDemo) Proxy.newProxyInstance(iDemo.getClass().getClassLoader(),
                iDemo.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.isAnnotationPresent(MyNotNull.class)) //如果有@Notnull这个注解，调用方法前，先判断参数是否为空，如果为空则给符默认值
                            args = homeWork_02.before(method, args);
                        return method.invoke(iDemo, args);
                    }
                });
     // String str = demo.getString("asdasd", 4565); //调用方法
       //String str = demo.getString("asdasd", 0); //使用默认age
        String str = demo.getString(null, 8989); //使用默认name，
        System.out.println(str);
    }
    //调用方法前执行：如果有@Notnull这个注解，则先判断参数是否为空，如果为空给默认值
    private Object[] before(Method m, Object[] args) throws ClassNotFoundException {
        ArrayList arrayList = new ArrayList();
        if (args != null) {
            for (int i = 0 ;i<args.length; i++){
                if(args[i]==null||args[i]==(Object) 0){ //传入参数为空,根据类型进行赋值

                    MyNotNull notNull = m.getAnnotation(MyNotNull.class);   //得到注解上赋值或默认值
                    String name = notNull.name();
                    Integer order = notNull.age();
                    arrayList.add(name); arrayList.add(order);

                    Type [] types = m.getGenericParameterTypes(); //函数形参类型
                    String typeName =types[i].getTypeName();

                    if(typeName.equals(arrayList.get(i).getClass().getTypeName())){
                        args[i] = arrayList.get(i);
                    }

                }
            }

        }
        return args;
    }
}

interface IDemo {
    //@MyNotNull(name = "是", order = 56)  //赋值时
    @MyNotNull  //不赋值时，使用注解默认值
    public String getString(String name, Integer age);
}

class Demo implements IDemo {

    @Override
    public String getString(String name, Integer age) {
        return "name:" + name + "\t\t" + "age:" + age;
    }
}