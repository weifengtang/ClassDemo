package com.twf.class_23;

import com.twf.class_23.demo1.P1;
import com.twf.class_23.demo1.P2;
import com.twf.class_23.demo1.demo_1_1.P3;
import com.twf.class_23.demo1.demo_1_1.P4;
import com.twf.class_23.demo1.demo_1_1.demo_1_2.P5;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName:HomeWork
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/139:41
 * @Version:1.0 •自定义注解@service,该注解使用在类级别上
 * 通 过反射扫描包类的@service创建该注解类的实例，
 * 并将实例储存到集合中
 **/
public class HomeWork_01 {
    static Class clazz = null;
    static String courseFile; //项目路径
    static String value; //注解上值
    static String m;
    static ArrayList<String> lists = new ArrayList<String>(); //存放对象实例
    boolean open = false;

    public static void main(String[] args) throws Exception {
        HomeWork_01 homeWork_01 = new HomeWork_01();
        try {
            clazz = Class.forName("com.twf.class_23.Configure");
            value = homeWork_01.getValue(Service.class);//得到注解上的value

            homeWork_01.getURL();  //得到类加载的根路径
            String pakeageName = value.replace('.', '/');    //替换成 com/twf/class_23/demo1
            m = value .replace('.', '/');
            homeWork_01.findJavaFile(pakeageName);//查找class文件
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(lists);
        String clazzName = lists.get(0);
        //P5 p = (P5) homeWork_01.createNewInstance(clazzName);
        P1 p = (P1) homeWork_01.createNewInstance(clazzName);
        p.setName("dddd");
        System.out.println("执行方法-"+p.getName());
    }

    //new
    private Object createNewInstance(String name) {
        //加载字节码文件 Object clazz = Thread.currentThread().getContextClassLoader().loadClass(pakeageName + '.' + className);
        Class clazz = null;
        Object object = null;
        try {
            clazz = Class.forName(name);
            object = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    //得到类加载的根路径
    public void getURL() {
//          File directory = new File("");// 参数为空
//         courseFile = directory.getCanonicalPath(); //得到项目路径
        // URL xmlpath = this.getClass().getClassLoader().getResource("");
        //courseFile = xmlpath.toString();
//        File f2 = new File(this.getClass().getResource("").getPath());
        // 第一种：获取类加载的根路径
        File f2 = new File(this.getClass().getResource("/").getPath());
        courseFile = f2.getPath();
        System.out.println("类加载的根路径：" + courseFile);

    }

    /**
     * 查找class文件
     */
    public  void findJavaFile(String pakeageName) {
        File pakeageFile = new File(courseFile + "/" + pakeageName);
        if(!pakeageFile.exists()||!pakeageFile.isDirectory())return;
        File[] dirfiles = pakeageFile.listFiles(new FileFilter() {
            @Override
            // 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
            public boolean accept(File fileFileter) { //过滤所有.java文件和目录，
                return (fileFileter.isDirectory()) || (fileFileter.getName().endsWith(".class"));
            }
        });

        for (File f : dirfiles) {
            if (f.isDirectory()&&open) {
                m = m+"/"+f.getName();
                System.out.println("目录（包）名称：File_Directory:  " + m);
                findJavaFile(m);
            }
            if(f.isFile()){
                String key = f.getName();
                String className = key.substring(0, key.lastIndexOf("."));//类名：P1.java --P1
                String str = pakeageName.replace('/', '.'); //包名： com.twf.class_23.demo1
                String name = str + '.' + className; //全限定类名
                System.out.println("全限定类名 Java_FileName:  " + name);
                lists.add(name);
            }
        }
    }

    /**
     * //得到注解上的value
     *
     * @param c
     * @return
     */
    private String getValue(Class c) {
        boolean flag = clazz.isAnnotationPresent(c);
        if (!flag) //是否存在这样的注解
           return "";
        Service annotation = (Service) clazz.getAnnotation(Service.class);
        String value = annotation.value();//得到Annotation中指定变量的内容
        System.out.println("注解 @Service value = " + value);//输出Annotation中的value
        if(value.endsWith("*")){ //com.twf.class_23.demo1.*
            value = value.substring(0,value.length()-2);
            open = true;
        }
        String a = value.substring(value.lastIndexOf('.')+1,value.length()); //类 com.twf.class_23.demo1.P1
        if(a.equals(a.toUpperCase())){
             value = a;
        }
        return value;
    }
}

/**
 *  1、com.twf.class_23.demo1.P1 直接指定类名 open =false
 *  2、com.twf.class_23.demo1    指定当前包 open =false
 *  3、com.twf.class_23.demo1.*  指定当前包及其子包下  open =true
 */
//@Service("com.twf.class_23.demo1.*")
//@Service("com.twf.class_23.demo1.P1")
@Service("com.twf.class_23.demo1")
class Configure {

}