package com.twf.class_15;

public class Demo_12 {
	
	
	public static void changeStr(String a) {
		System.out.println("1-->"+a);
		a = "welcome";
		System.out.println("2-->"+a);
	}

	public static void main(String[] args) {
		String str = "1234";//字符串 final
		changeStr(str);//传递的是 str引用的副本；
		System.out.println("3-->"+str);
	}

}
