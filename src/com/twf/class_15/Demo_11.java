package com.twf.class_15;

public class Demo_11 {

	public static void main(String[] args) {
		Dog woofer = new Dog();
		Dog nipper = new Basenji();
		woofer.bark(); //woof
		nipper.bark();//woof  子类不能覆盖父类的静态方法
	}

}

class Dog {
	public static void bark() {
		System.out.println("woof ");
	}
}

class Basenji extends Dog {
	//@Override 子类不能覆盖父类的静态方法 ；复写是动态绑定
	public static void bark() {
		System.out.println("Basenji");
	}
}