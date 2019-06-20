package com.twf.class_15;

public class Demo_14 {
	public static void main(String[] args) {
		someMethod(1); //编译器找 最匹配的类型 匹配
		someMethod((Integer)1);
	}

	public static void someMethod(int i) {
		System.out.println("int 版本被调用");
	}

	public static void someMethod(Integer i) {
		System.out.println("Integer 版本被调用");
	}

}
