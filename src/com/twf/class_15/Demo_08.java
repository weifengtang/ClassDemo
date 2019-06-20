package com.twf.class_15;

import java.util.Scanner;

public class Demo_08 {
	// 一个会员拥有产品的最多数量
	public final static int LIMIT = 2000;
	
	/**
	 *输入：2147483647 时整型int数据溢出；变负数
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// 会员当前拥有的产品数量
		int cur = 1000;
		Scanner input = new Scanner(System.in);
		System.out.print("请输入需要预定的数量：");
		while (input.hasNextInt()) {
			int order = input.nextInt();// 当前拥有的与准备订购的产品数量之和
			if (order>Integer.MIN_VALUE&&order<Integer.MAX_VALUE&&order > 0 && order + cur <= LIMIT) { 
				System.out.println("你已经成功预定的" + order + "个产品！");
			} else {
				System.out.println("超过限额，预订失败！");
				break;
			}
			
		}

	}

}
