package com.twf.class_15;

public class Demo_01 {

	/**
	 * 三目运算： 表达式类型要一致
	 * 如不一致：
	 * 		类型可以转换，则向上转型
	 *		类型不能转换，则返回Object类型
	 * @param args
	 */
	public static void main(String[] args) {
		char x = 'X';
		int i = 0;
		
		System.out.println("X = "+(int)'X');//88
		
		System.out.println(true ?new Person("站三"):"ss");//X
		System.out.println(true?x:0);//X           0也可当作char类型
		System.out.println(true?x:65536);//88
		System.out.println(true?x:i);//88
		System.out.println(false?0:x);//X
		System.out.println(false?i:x);//88
		
	}

}

class Person{
	String nameString;

	public Person(String nameString) {
		super();
		this.nameString = nameString;
	}
	
}