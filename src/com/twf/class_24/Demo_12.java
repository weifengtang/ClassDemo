package com.twf.class_24;



/**
 * @ClassName:Demo_12
 * @Description TODO
 * @Author:TWF
 * @Date:2019/6/1621:02
 * @Version:1.0
 **/
interface Inter {
}

class A {
}

class B extends A implements Inter {}

    public class Demo_12 extends B {
        public static void main(String[] args) {
            A a = new A();
            B b = new B();
            Demo_12 c = new Demo_12();
            if (a instanceof B) {
                System.out.println("Hello A");
            }
            if (b instanceof A) {
                System.out.println("Hello B");  // ok
            }
            if (c instanceof Demo_12) {
                System.out.println("Hello C");  // ok
            }
            if (c instanceof Inter) {
                System.out.println("Hello I");// ok
            }
        }

    }
