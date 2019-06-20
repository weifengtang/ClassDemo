package com.twf.class_10;

import java.util.Random;

public class Demo_04 {

	public static void main(String[] args) {
		/**
		 * 是常量：但常量尽量不能定义为变化的数值
		 */
		for (int i = 0; i < 5; i++) {
			System.out.println(Const.RAND_CONST);
		}
	}

}

interface Const{
	public static final int RAND_CONST = new Random().nextInt();
}