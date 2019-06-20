package com.twf.class_02;



/***
 * 1 -1000奇数和
 * @author TWF
 *
 */
public class IsOdd {

	public static void main(String[] args) {
		/*公式算法一
		 * int n = 1000>>1; int sum = 0; sum=n*1+n*(n-1)*2/2;
		 */
		Long startTime = System.nanoTime();
		int sum = 0;
		for (int i = 1; i <1000; i+=2) {
			if(isOdd(i)) {
				sum+=i;		
			}
		}
		Long totalTime = System.nanoTime()-startTime;
		System.out.println(totalTime);
		System.out.println(sum);			
	}

	//判断是否为奇数
	public static boolean isOdd(int number) {
		return (number&1)==1;
	}
}
