package com.twf.class_02;

import java.util.Arrays;

/*吸血鬼数字是指位数为偶数的数字，
 * 可以由一对数字相乘而得到，而这对数字各包含乘积的一半位数的数字，其中从最初的数字中选取的数字可以任意排序
 * 找出4位数的所有吸血鬼的数字。例如：
1260=21*60
1827=21*87
 * 
 * 
 */
public class VampireDemo {
	
	
	public static void main(String[] args) {
	fun();

	}


	public static void fun(){
		int sum = 0 ;
		for (int i = 10; i <= 99; i++) {
			for (int j = i + 1; j <= 99; j++) {
				// 计算出所有两位数的积
				sum = i * j;
				if (sum <= 9999 && sum >= 1000) {
					String[] t1 = (sum + "").split("");
					// 对数组t1进行升序排列
					Arrays.sort(t1);
					// 这个地方，把i和j都当String型的字符串加起来组成一个四位数
					String[] t2 = ("" + i + j).split("");
					// 对t2进行升序排列
					Arrays.sort(t2);
					//下面判断是通过两个已经排好序的数组相比较，当完全相同时执行
					if (Arrays.equals(t1, t2)) {
						System.out.println(i + "*" + j + "=" + i * j);
					}
				}
			}
		}


	}
}
