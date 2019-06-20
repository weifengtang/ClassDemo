package com.twf.class_10;

public class Demo_06 {

	
	/**
	 * 可变参数列表    可以不传参数
	 * @param str
	 * @param i
	 */
	public void methodA(String str,int...integers ) {
		System.out.println("methodA(String str,Integer ...i)");
	}
	
	public void methodA(String str,String... Str) {
		System.out.println("methodB(String str,String ...Str)");
	}
	
	
	
	public static void main(String[] args) {
		Demo_06 demo_06 = new Demo_06();
		
		demo_06.methodA("China",0);
		demo_06.methodA("China","people");
		demo_06.methodA("China","");
//		demo_06.methodA("China");
		
	}

	
	
}
