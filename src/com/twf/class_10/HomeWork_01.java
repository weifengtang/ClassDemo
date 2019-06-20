package com.twf.class_10;

/**
 * 使用循环从1加到1000
•请提供最少两种以上实现方式
•自己对比分析两种方式的优劣(耗时和内存 等方面)
 * @author TWF
 *
 */
public class HomeWork_01 {

	public static void main(String[] args) {
		long start1 = System.nanoTime();
		System.out.println("for循环--从1加到1000的和：  "+fun1(1,1000000000));
		Long end1 = System.nanoTime();
		
		long start2 = System.nanoTime();
		System.out.println("组合---从1加到1000的和：  "+fun2(1,1000000000));
		Long end2 = System.nanoTime();
		
		long start3 = System.nanoTime();
		System.out.println("while循环---从1加到1000的和：  "+fun3(1,1000000000));
		Long end3 = System.nanoTime();
		
		long start4 = System.nanoTime();
		System.out.println("do-while循环---从1加到1000的和：  "+fun4(1,1000000000));
		Long end4 = System.nanoTime();
		
		
		
		
		
		System.out.println();
		
		
		System.out.println("for循环--耗时1  "+(end1-start1));
		System.out.println("组合---耗时2    "+(end2-start2));
		System.out.println("while循环---耗时2    "+(end3-start3));
		System.out.println("do-while循环---耗时2    "+(end4-start4));
	}
	
	//for循环
	public static int fun1(int a,int b) {
		int sum = 0 ;
		for (int i = a; i <= b; i++) {
			sum +=i;
		}
		return sum;
	}
	//while循环
	public static int fun3(int a,int b) {
		int sum = 0 ;
		while (a<=b) {
			sum +=a;
			a++;
		}
		return sum;
	}
	//do-while循环
	public static int fun4(int a,int b) {
		int sum = 0 ;
		do {
			sum +=a;
			a++;
		}while (a<=b);
		return sum;
	}
	
	//组合
	public static int fun2(int a,int b) {
		return ((a+b)*(b-a+1))>>1;
	}
}
