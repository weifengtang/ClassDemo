package com.twf.class_15;

public class Demo_09 {
	public static void main(String[] args) {
		System.out.println(X.Y.Z);
	}

}
//优先使用静态类成员，类中的类不管是不是静态的，都相当于一个外部的类，而不是静态成员
class X {
	
	static C Y = new C(); //静态属性类
	
	static class Y { //静态内部类
		static String Z = "Black";
	}
	
}
class C {
	String Z = "White";
}