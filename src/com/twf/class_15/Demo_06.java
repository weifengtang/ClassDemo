package com.twf.class_15;

public class Demo_06 {

	public static void main(String[] args) {
		//编译器 优先 匹配 最靠近的子类
		new Demo_06(null); //Double array
		new Demo_06(""); //Object
	}

	private Demo_06(Object o) {
		System.out.println("Object");
	}
	//数组是引用类型，最大父类也是Object
	private Demo_06(double[] doubleArray) { 
		System.out.println("Double array");
	}

}
