package com.twf.class_22;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.InetAddress;

/**
 * @ClassName:HomeWork_01
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1216:38
 * @Version:1.0
 **/
public class HomeWork_01 {

    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.twf.class_22.Student");
        Object object = clazz.newInstance();
        Method[] methods = clazz.getDeclaredMethods();//所有方法

        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("set")) {
                Class<?>[] parameterTypes = method.getParameterTypes(); //参数类型
                String parameterName = parameterTypes[0].getName();
                if (parameterName.equals(String.class.getName())) {
                    method.invoke(object, "张三");
                } else if (parameterName.equals(Integer.class.getName())) {
                    method.invoke(object, 22);
                }
            }
        }
        System.out.println(object);


        Method method2 = clazz.getMethod("getName");
        Object ot = method2.invoke(object);
        System.out.println(ot);



    }

}

class Student {
    private String name = "张三";
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
