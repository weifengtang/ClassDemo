package com.twf.class_10;

public class Demo_02 {

	public static void main(String[] args) {
		/**
		 * for循环执行步骤：
		 * 	1、初始 i的值；
		 * 	2、中间为判断语句；满足则执行{}内代码；
		 * 	3、执行完毕或不满足判断语句；执行i++;
		 * 
		 */
		int a = 0;
		float b = 0.1F;
		for (int i = 0; i < 100; i++) {
			a++;
			System.out.println("i的值 = "+i);
			 //i>>=1; // i= i*0.1;
			i*=b;//i=i*b;
			if(a>10) {
				break; //0 0.1 0.11 0.111
			}
		}
	}

}
