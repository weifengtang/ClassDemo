package com.twf.class_02;

import java.text.DecimalFormat;

/**
 * 
 * 打印1~1000范围内的水仙花数，
 *  水仙花数是指一个三位数，其各位数字的立方和等于该数本身
 * 
 * @author TWF
 *
 */

public class LakeNumber {

	
	
	
	/*
	 * 判断是否为水仙花数
	 */
	public static Boolean lake(Integer number) {
		int hundred = number/100;
		int ten = (number-hundred*100)/10;
		int bit = (number-hundred*100-ten*10);
		return number==(hundred*hundred*hundred+ten*ten*ten+bit*bit*bit);
	}
	

	public static void main(String args[]) {
		int count = 0;
		Long startTime = System.nanoTime();
		for (int i = 99; i < 1000; i++) {
			if(lake(i)) {
				count++;
				System.out.println("水仙花数:  "+i);
			}
		}
		System.out.println("总共有：\t"+count);
		Long totalTime =  System.nanoTime()-startTime;
		System.out.println("耗时:\t"+new DecimalFormat("#.000").format(totalTime)+"ns"); 

	}
}
