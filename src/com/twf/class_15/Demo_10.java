package com.twf.class_15;

/**
 * 
 *@Classname:Demo_10 
 *@author TWF
 *@Date:2019年5月31日下午3:59:26
 *@version 1.0
 *
 *•设计一个计算java方法代码 执行耗时(毫秒) 和内存消耗(KB)的功能类,
 *在方法执行后能反 馈给用户方法耗时和内存消耗的情况 •应用代理设计模式实现 •给出几个测试应用,观察执行情况
 *
 */
public class Demo_10 {

	public static void main(String[] args) {
		StringBuffer s = new StringBuffer("Hello");
		//if ((s.length() > 5) && (s.append("there").equals("False")));
		if ((s.append("there").equals("False"))&&(s.length() > 5));//双&& 短路运算
		System.out.println("value  is " + s);
	}
}
