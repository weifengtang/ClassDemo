package com.twf.class_15;

import java.math.BigDecimal;

/**
 * 
 * 
 *@Classname:Demo_04 
 *@author TWF
 *@Date:2019年5月31日下午2:18:54
 *@version 1.0
 */
public class Demo_04 {

	public static void main(String[] args) {

		/**
		 * float,double 十进制转换二进制，精度丢失
		 */
		//为什么显示剩余金额很奇怪？ 
		Float totalMoneyFloat = 20000.8F;
		Float ownMoneyFloat  = 17000.5F;
		Float lastMoney = totalMoneyFloat - ownMoneyFloat;
		System.out.println("-Float剩余金额："+lastMoney);//3000.3008
		
		System.out.println("--------------------\n");
		
		//金融计算 使用BigDecimal
		BigDecimal total =new BigDecimal("20000.8");
		BigDecimal own =new BigDecimal("17000.5");
		BigDecimal last =total.subtract(own);
		System.out.println("BigDecimal-剩余金额："+last);//3000.3008
	}

}
