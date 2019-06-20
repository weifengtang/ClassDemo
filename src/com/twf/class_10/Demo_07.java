package com.twf.class_10;

/*
 * 
 * 可变参数列表：动态绑定 时 参数的二义性
 */

class Base {// 基类
	void fun(int price, int... discounts) {
		System.out.println("Base……fun");
	}
}

class Sub extends Base {// 子类,覆写父类方法
	
	  @Override
	  void fun(int price, int[] discounts) {
		  System.out.println("Sub……fun");
	  }
	 
	/*
	 * void fun(int price, int discounts) { System.out.println("Sub……fun"); }
	 */
}

public class Demo_07 {
	public static void main(String[] args) {

		/**
		 * 
		 * 编译期，看父类是否有此方法 
		 * 运行时，动态绑定到对应子类方法
		 * 
		 */
		Base base = new Sub();// 向上转型
		// base.fun(100, 50);
		base.fun(222);

		Sub sub = new Sub();// 不转型
//		sub.fun(222);//传一个参数时，编译报错，编译器不知道要调用父类方法 二异性
		 sub.fun(100,new int[]{50,40});
	}
}
