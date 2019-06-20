package com.twf.class_02;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 解决： 1、异常后继续执行输入
 *  2、多态（动态绑定）
 *
 * @param
 */
public class JavaBaseDemo02 {

	public static void main(String[] args) {


/*		 // 异常处理
		int i = 0;
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {

				i = sc.nextInt();

				if (i > 5)
					throw new IOException("i>5");
				System.out.println("输入的值为： " + i);
				break;
			} catch (IOException e1) {
				System.out.println("数据值>5--");
			} catch (InputMismatchException e) {
				sc.next();
				System.out.println("数据类型错误,请重新输入--"+e);
			}
		}*/

		//案例一
		System.out.println(fun1());
		System.out.println("-----------------");
		//案例二
		System.out.println(fun2());
		System.out.println("-----------------");
		Parent p = new Son();
		System.out.println(Parent.a);
		p.name();
	}
	private static int fun2() {
		try {
			return test1();
		}finally {
			return test2();
		}
		
	}
	private static int test1() {
		System.out.println("test1");
		return 1;
	}
	private static int test2() {
		System.out.println("test2");
		return 2;
	}
	/**
	 * try {}里有一个return语句，
	 * 那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后?
	 */
	public static int  fun1() {
		
		int x = 1;
		try {
			return x;
		}finally {
//			return ++x;  //2
			System.out.println("---finally:"+x);
			 ++x; //1
			 System.out.println("finally:"+x);
		}
		
		
	}

}

class Parent {
	static int a = 1;

	public void name() {

		System.out.println("爸爸");
		return;// 可以省略
	}
}

class Son extends Parent {

	static int a = 3;

	@Override
	public void name() {
		// super.name();
		System.out.println("儿子");
	}

	public void name(int i) {
		// super.name();
		System.out.println("儿子");
	}


}


interface Inter{

}