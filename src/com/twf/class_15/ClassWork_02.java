package com.twf.class_15;

/**
 * 设计一个计算java方法代码 执行耗时(毫秒) 和内存消耗(KB)的功能类, 在方法执行后能反 馈给用户方法耗时和内存消耗的情况
 *  •应用代理设计模式实现
 * •给出几个测试应用,观察执行情况
 * 
 * @Classname:ClassWork_02
 * @author TWF
 * @Date:2019年5月31日下午5:00:58
 * @version 1.0
 */
public class ClassWork_02 {
	public static void main(String[] args) {

		Long maxLong = Runtime.getRuntime().maxMemory(); //Java 虚拟机试图使用的最大内存量
		Long freeLong = Runtime.getRuntime().freeMemory();//Java 虚拟机中的空闲内存量。
		Long totalLong = Runtime.getRuntime().totalMemory();//Java 虚拟机中的内存总量
		
		
		System.out.println("试图使用的最大内存量:"+(maxLong>>10)+" KB");
		System.out.println("空闲内存量:"+(freeLong>>10)+" KB");
		System.out.println("内存总量:"+(totalLong>>10)+" KB");







	}

}
