package com.twf.class_15;
/**
 * 整数包装类对象比较???
 * 
 *@Classname:Demo3 
 *@author TWF
 *@Date:2019年5月31日下午2:15:51
 *@version 1.0
 */
public class Demo_03 {

	/**
	 * JVM会自动维护八种基本类型的常量池，
	 * int常量池中初始化-128~127（1个字节）的范围，所以当为Integer i=127时，
	 * 在自动装箱过程中是取自常量池中的数值， 而当Integer i=128时，
	 * 128不在常量池范围内，所以在自动装箱过程中需new 128，所以地址不一样。
	 * 虚拟机为优化运算把  字符常量，字面常量，数字常量 都在常量池 -127-127
	 * 
	 * 超过此数值范围的  须在堆中开辟空间存储
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Integer one = 128;
		Integer two = 128;
		System.out.println(one == two); //false
		
		Integer one2 = 100;
		Integer two2 = 100;
		System.out.println(one2 == two2);//true

	}

}
