package com.twf.class_24;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName:Demo_16
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1621:53
 * @Version:1.0
 * •下面代码能正确判断相同内容吗?
 **/
public class Demo_16 {
    private String firstName, lastName;

    public Demo_16(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Demo_16)) { //Object不是 它的实例；传入的是Demo_16
            return false;
        }
        Demo_16 t = (Demo_16) o; //向下转型
        return t.firstName.equals(firstName) && t.lastName.equals(lastName);
    }

    public static void main(String[] args) {
        Set<Demo_16> s = new HashSet<Demo_16>();
       // s.add(new Demo_16("Mickey", "Mouse"));
        //System.out.println(s.contains(new Demo_16("Mickey", "Mouse"))); //new 的对象地址不同
        Demo_16 d = new Demo_16("Mickey", "Mouse");
        s.add(d);
        System.out.println(s.contains(d));
    }
}
