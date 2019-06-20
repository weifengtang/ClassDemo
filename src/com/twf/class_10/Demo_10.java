package com.twf.class_10;

public class Demo_10 {

	public static void main(String[] args) {
		Father base = new Son();
		//base.doTest(); // 调用父静态方法
		base.notStatic();// 调用子类非静态方法 
	}

}

class Father {// 父类静态方法
	public static void doTest() {
		System.out.println("我是父类静态方法");
	}

	public void notStatic() { // 父类非静态方法
		System.out.println("我是父类非静态方法");
	}
}

class Son extends Father { // 子类同名、同参数的静态方法
	//@Override
	public static void doTest() {//没有重写父类静态方法
		System.out.println("我是子类静态方法");
	}
	@Override
	public void notStatic() {// 覆写父类的非静态方法
		System.out.println("我是子类非静态方法");
	}
}
