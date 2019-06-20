package com.twf.class_02;

/**
 * 1-10000之间7的倍数的整数个数 及总和
 * 
 * @author TWF
 *
 */
public class Is7Multiple {

	public static void main(String[] args) {
		fun1();

	}


	public static void fun1() {
		int sum = 0, count = 0;
		Long startTime = System.nanoTime();
		for (int j = 7; j < 10000; j += 7) {
			sum += j;
			count++;
		}

		Long totalTime = System.nanoTime() - startTime;

		System.out.println("1-10000之间7的倍数的整数个数 : " + count + " 总和： " + sum);
		System.out.print("耗时：" + totalTime);
	}

}
