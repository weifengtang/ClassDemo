package com.twf.class_22;

import com.twf.class_03.Demo;

import java.io.InputStream;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @ClassName:Demo_02
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1214:32
 * @Version:1.0 类加载器：双亲委托机制
 **/
public class Demo_02 {

    public static void main(String[] args) throws ClassNotFoundException {
        //1.获取一个系统类加载器
        ClassLoader classloader = ClassLoader.getSystemClassLoader();
        System.out.println(classloader);
        //2.获取系统类加载器的父类加载器,即扩展类加载器
        classloader = classloader.getParent();
        System.out.println(classloader);
        // 3.获取扩展类加载器的父类加载器,即引导类加载器
        classloader = classloader.getParent();
        System.out.println(classloader);
        System.out.println("------------------------------");

//         4.测试当前类由哪个类加载器进行加载
        classloader = Class.forName("com.twf.class_22.Demo_02").getClassLoader();
        System.out.println(classloader);
//         5.测试JDK提供的Object类由哪个类加载器加载
        classloader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classloader);
//         *6.关于类加载器的一个主要方法： getResourceAsStream(String str): 获取类路径下的指定 文件的输入流
        InputStream in = null;
        in = new Demo().getClass().getClassLoader().getResourceAsStream("com\\test.properties");
        System.out.println(in);

        System.out.println("------------");
        Class clazz = Class.forName("javax.swing.JFrame");
        while (true) {
            clazz = clazz.getSuperclass();
            System.out.println(clazz.getName());
            if ("java.lang.Object".equals(clazz.getName())) {
                break;
            }
        }
        System.out.println("--------------------");
        Class c = DD.class; //第一种
       // Class c = new DD().getClass();//第二种

       // Class [] i = c.getInterfaces(); //只能得到当前类实现的接口
        Class [] i = c.getInterfaces();
        for (int j = 0; j < i.length; j++) {
            System.out.println(i[j].getName());
        }
        System.out.println("--------------------");
        Type t = c.getGenericSuperclass();
        System.out.println(t);
        if (ParameterizedType.class.isAssignableFrom(t.getClass())) {
            System.out.print("getActualTypeArguments:");
            for (Type t1 : ((ParameterizedType) t).getActualTypeArguments()) {
                System.out.print(t1 + ",");
            }
            System.out.println();
        }



    }
}

class DD<Integer> implements AA<String>,CC{

}

interface AA<String> extends BB,CC{ //接口之间可以用多继承

}

interface BB {

}
interface CC {

}