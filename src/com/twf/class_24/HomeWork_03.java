package com.twf.class_24;

import java.io.*;

/**
 * @ClassName:HomeWork_03
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1711:58
 * @Version:1.0 使用对象序列化反序列化ObjectOutputStream 类和ObjectInputStream类,
 * 对用户的数据进行保存和读取,例如,先在程序中创建了
 * 以下的三个对象数据使用序列化保存为user.dat文件,再通过反序 列化对象读取出来：
 * •zhangsan,30 •lisi,31 •wangwu,32
 **/
public class HomeWork_03 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("D:/temp");
        file.mkdir();
//      User user = new User("张三",22,"篮球");
//      User.job = "项目精灵";
//      System.out.println(user);
//        //序列化
//        FileOutputStream fileOutputStream = new FileOutputStream(new File(file,"user.txt"),true);
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(user);
//        System.out.println(user);
//        objectOutputStream.close();
/**
 * 前面代码注释前：
 * User{name='张三', age=22, hobby='篮球', job='项目精灵'}
 * User{name='张三', age=22, hobby='篮球', job='项目精灵'}
 * User{name='张三', age=22, hobby='null', job='项目精灵'}
 * 前面代码注释后：
 *User{name='张三', age=22, hobby='null', job='程序员'}
 * 原因：
 * hobby因为是加了transient所以不参与序列化没有被保存起来。
 * job回到了原来的值  程序员 ，而在第一次测试里第三次打印的结果是男，因为第一次测试里jvm并没有停止，
 * 所以方法区里job的值被设置后确实变成了  项目精灵，而静态变量是不参与序列化的，所以第一个测试程序里读取反序列化对象时，
 * 因为都是Student类所以都使用同一个地址上的值，而sex这个地址上的值已经被改变，所以打印的结果也被改变。
 * 而第二次测试里jvm已经重启，原来方法区里的job的地址已经消失，在读取反序列化对象时又会进行一次类加载，
 * 加载时就会按照Student里写的static的默认值重新分配地址和默认值，所以读取的结果就是原来的值了。

 *
 *
 */


        //反序列化
        FileInputStream fileInputStream = new FileInputStream(new File(file, "user.txt"));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        User u = (User) objectInputStream.readObject();
        System.out.println(u);

        int a = 0b11; //jdk7新特性：二进制字面量
        System.out.println(a);
        int b = 110_22_22; //数字字面量可以出现下划线
        System.out.println(b);

    }
}

class User implements Serializable {
    private String name;
    private  Integer age = 11;
    //transient修饰过的变量不参与序列化，String默认值是为null，数值则为0
    public transient String hobby ="吃迟迟"; //不可被序列存储

    public static String job = "程序员"; //静态变量不参与序列化

    public User() {
    }

    public User(String name, Integer age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby='" + hobby + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}