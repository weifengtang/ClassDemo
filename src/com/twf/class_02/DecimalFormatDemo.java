package com.twf.class_02;
import java.text.DecimalFormat;

/*
 * 数字格式化
 * 
 * 输出double类型的小数点后3位:
 */
public class DecimalFormatDemo {

	public static void main(String[] args) {
		double d = 123456.23456;
		System.out.printf("%12.6f",d);
		System.out.println();
		System.out.println(new DecimalFormat("0000000000.000").format(d)); 
		
		//System.out.println(D.a);
		/**
		 * 对算术运算的理解
		 */
		System.out.println(4.5%2); //0.5
		System.out.println(4.5/2); //2.25
	
		System.out.println(5/-2); //-2
		System.out.println(5%-2); //1
		
		System.out.println(-5/2); //-2
		System.out.println(-5%2); //-1
		
		
		System.out.println(-3%2==1); //-1 false
		System.out.println(-3%2==0);//false
		
		
		
	}
	
}
class D{
	//public final static int a = 2;  //加final a成为静态常量
	public  static int a = 2;         //a为类成员变量
	
	static {
		System.out.println("static");
	}
}