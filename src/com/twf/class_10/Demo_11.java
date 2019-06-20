package com.twf.class_10;


/**
 * 
 *  调用本类构造之前先super();
 * @author TWF
 *
 */
public class Demo_11 {

	public static void main(String[] args) {
		Son1 s = new Son1(); 
		s.test();
	}

}

class FatherA {// 父类
	FatherA() {
		new Other();
	}
}

class Son1 extends FatherA {// 子类
	public void test() {
		System.out.println("Hi, show me test");
	}
}

class Other {// 相关类
	public Other() {
		new Son1();
	}
}
