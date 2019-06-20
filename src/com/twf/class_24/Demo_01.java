package com.twf.class_24;

/**
 * @ClassName:Demo_01
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1417:16
 * @Version:1.0
 **/
public class Demo_01 {
}

/**
 * 此类实现了 Cloneable 接口，以指示 Object.clone() 方法可以合法地对该类实例进行按字段复制。
 *
 * 如果在没有实现 Cloneable 接口的实例上调用 Object 的 clone 方法，则会导致抛出 CloneNotSupportedException 异常。
 *
 * 按照惯例，实现此接口的类应该使用公共方法重写 Object.clone（它是受保护的）。请参阅 Object.clone()，以获得有关重写此方法的详细信息。
 *
 * 注意，此接口不 包含 clone 方法。因此，因为某个对象实现了此接口就克隆它是不可能的。即使 clone 方法是反射性调用的，也无法保证它将获得成功。
 *
 */
class Person implements Cloneable { // 姓名
    private String name; // 父亲
    private Person father;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Person father) {
        this.name = name;
        this.father = father;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Person f = new Person("小头爸爸");// 定义父亲
        Person s1 = new Person("大儿子", f);// 定义大儿子 // 小儿子的信息是通过大儿子拷贝过来的
        Person s2 = (Person)s1.clone();
        s2.setName("小儿子");
        System.out.println(s1.getName() + "的父亲是" + s1.getFather().getName());
        System.out.println(s2.getName() + "的父亲是" + s2.getFather().getName());
    }

    @Override
    public   Object clone() throws CloneNotSupportedException {
        System.out.println("如果在没有实现 Cloneable 接口的实例上调用 Object 的 clone 方法，则会导致抛出 CloneNotSupportedException 异常。 " +
                "用公共方法重写 Object.clone（它是受保护的）\n");
        return super.clone();
    }
}