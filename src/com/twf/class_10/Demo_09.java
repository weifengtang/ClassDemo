package com.twf.class_10;

public class Demo_09 {

	//.class加载道内存时同时加载静态代码块；
	static { //1、静态代码块
		i= 1;
		System.out.println("静态代码块      类加载时 运行   "+Demo_09.i);
	}
	
	public static int i = 2;
	
	{
		i=3;
		System.out.println("构造代码块     每次调用构造都执行  " +i);
	}
	
	public Demo_09() {
		i=4;
		System.out.println("构造函数        "+i);
	}

	
	public static void main(String[] args) {
		System.out.println("static     静态变量中  "+i);
		new Demo_09();
		
	}

}
